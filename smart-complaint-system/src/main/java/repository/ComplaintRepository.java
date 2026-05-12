package com.smartcomplaint.system.repository;

import com.smartcomplaint.system.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
