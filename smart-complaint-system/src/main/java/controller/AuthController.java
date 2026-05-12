package com.smartcomplaint.system.controller;

import com.smartcomplaint.system.entity.Admin;
import com.smartcomplaint.system.entity.User;
import com.smartcomplaint.system.repository.AdminRepository;
import com.smartcomplaint.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    // USER REGISTER
    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // USER LOGIN
    @PostMapping("/user/login")
    public User loginUser(@RequestBody User user) {
        return userRepository.findByEmailAndPassword(
                user.getEmail(), user.getPassword()
        );
    }

    // ADMIN REGISTER
    @PostMapping("/admin/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // ADMIN LOGIN
    @PostMapping("/admin/login")
    public Admin loginAdmin(@RequestBody Admin admin) {
        return adminRepository.findByAdminIdAndPassword(
                admin.getAdminId(), admin.getPassword()
        );
    }
}
