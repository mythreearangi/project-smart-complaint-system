package com.smartcomplaint.system.repository;

import com.smartcomplaint.system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByAdminIdAndPassword(String adminId, String password);
}
