package com.smartcomplaint.system.service;

import com.smartcomplaint.system.entity.Complaint;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AiService {

    // Existing AI logic
    public Map<String, Object> analyzeComplaint(String description) {
        Map<String, Object> result = new HashMap<>();

        description = description.toLowerCase();

        if (description.contains("water")) {
            result.put("category", "Water");
            result.put("priority", 4);
        } else if (description.contains("electric")) {
            result.put("category", "Electricity");
            result.put("priority", 3);
        } else if (description.contains("road")) {
            result.put("category", "Roads");
            result.put("priority", 3);
        } else if (description.contains("hostel")) {
            result.put("category", "Hostel");
            result.put("priority", 4);
        } else {
            result.put("category", "Others");
            result.put("priority", 2);
        }

        return result;
    }

    // ✅ NEW: Time-based AI escalation
    public int adjustPriorityForDelay(Complaint complaint) {

        if ("RESOLVED".equals(complaint.getStatus())) {
            return complaint.getPriority();
        }

        long hoursPending = Duration.between(
                complaint.getCreatedAt(),
                LocalDateTime.now()
        ).toHours();

        int updatedPriority = complaint.getPriority();

        if (hoursPending >= 48) {
            updatedPriority += 2;
        } else if (hoursPending >= 24) {
            updatedPriority += 1;
        }

        return Math.min(updatedPriority, 5);
    }
}
