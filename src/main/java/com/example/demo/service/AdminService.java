package com.example.demo.service;

import com.example.demo.model.Profile;
import com.example.demo.model.users.Admin;
import com.example.demo.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        Profile profile = admin.getProfile();
        profile.setCreated(LocalDate.now(ZoneId.of("Europe/Paris")));
        admin.setProfile(profile);
        adminRepository.save(admin);
    }

    public void deleteAdmin(String adminId) {
        boolean exists = adminRepository.existsById(adminId);

        if(!exists){
            throw new IllegalStateException("Admin with "+adminId+" id does not exists.");
        }

        adminRepository.deleteById(adminId);
    }

    @Transactional
    public void updateAdmin(String adminId,
                            Profile profile,
                            String position) {
        Admin admin = adminRepository.findById(adminId).
                orElseThrow(()-> new IllegalStateException(
                        "Admin with "+adminId+" id does not exists."));

        if(profile != null &&
                !Objects.equals(admin.getProfile(), profile)) {
            Profile actualProfile = admin.getProfile();
            profile.setCreated(actualProfile.getCreated());
            admin.setProfile(profile);
        }


        if(position != null &&
                !Objects.equals(admin.getPosition(), position)){
            admin.setPosition(position);
        }


        adminRepository.save(admin);
    }

    @Transactional
    public void changeAdminPassword(String adminId, String password) {
        Admin admin = adminRepository.findById(adminId).
                orElseThrow(()-> new IllegalStateException(
                        "Admin with "+adminId+" id does not exists."));

        if(password != null &&
                password.length()>3 &&
                !Objects.equals(admin.getPassword(), password)){
            admin.setPassword(password);
        } else {
            throw new IllegalStateException(
                "New password is the same like an old password for admin with "+adminId+" id or is less than 3 characters.");
        }

        adminRepository.save(admin);
    }

    @Transactional
    public void changeAdminEmail(String adminId, String email) {
        Admin admin = adminRepository.findById(adminId).
                orElseThrow(() -> new IllegalStateException(
                        "Admin with "+adminId+" id does not exists."));

        // TODO validate email has correctly form
        if(email != null &&
                !Objects.equals(admin.getEmail(), email)) {
            admin.setEmail(email);
        } else {
            throw new IllegalStateException("Error with changing admin email.");
        }

        adminRepository.save(admin);
    }
}
