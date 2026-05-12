package com.smartcomplaint.system.controller;

import com.smartcomplaint.system.entity.Complaint;
import com.smartcomplaint.system.repository.ComplaintRepository;
import com.smartcomplaint.system.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private AiService aiService;

    // ✅ 1. Submit complaint (User)
    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody Complaint complaint) {

        // AI text-based analysis
        var aiResult = aiService.analyzeComplaint(complaint.getDescription());

        complaint.setCategory((String) aiResult.get("category"));
        complaint.setPriority((Integer) aiResult.get("priority"));
        complaint.setStatus("SUBMITTED"); // use consistent status

        // createdAt & lastUpdatedAt handled automatically
        return complaintRepository.save(complaint);
    }

    // ✅ 2. Get all complaints (Admin) + AI time-based escalation
    @GetMapping("/all")
    public List<Complaint> getAllComplaints() {

        List<Complaint> complaints = complaintRepository.findAll();

        // AI re-prioritize long-pending complaints
        complaints.forEach(c -> {
            int updatedPriority = aiService.adjustPriorityForDelay(c);
            c.setPriority(updatedPriority);
        });

        // Save updated priorities
        complaintRepository.saveAll(complaints);

        return complaints;
    }

    // ✅ 3. Update complaint status (Admin)
    @PutMapping("/update/{id}")
    public Complaint updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Complaint complaint = complaintRepository.findById(id).orElse(null);

        if (complaint != null) {
            complaint.setStatus(status.toUpperCase());
            return complaintRepository.save(complaint);
        }

        return null;
    }
}
