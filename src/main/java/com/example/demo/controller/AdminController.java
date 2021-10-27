package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.model.users.Admin;
import com.example.demo.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/admins")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping()
    public void addNewAdmin(@RequestBody Admin admin){
        adminService.addNewAdmin(admin);
    }

    @DeleteMapping(path = "/delete/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") String adminId){
        adminService.deleteAdmin(adminId);
    }

    @PatchMapping(path = "/update/{adminId}")
    public void updateAdmin(@PathVariable("adminId") String adminId,
                            @RequestBody(required = false) Profile profile,
                            @RequestParam(required = false, value = "position") String position){
        adminService.updateAdmin(adminId,profile,position);
    }

    @PatchMapping(path = "/change-password/{adminId}")
    public void changeAdminPassword(@PathVariable("adminId") String adminId,
                                    @RequestParam(value = "password") String password){
        adminService.changeAdminPassword(adminId,password);
    }

    @PatchMapping(path = "/change-email/{adminId}")
    public void changeAdminEmail(@PathVariable("adminId") String adminId,
                                 @RequestParam(value = "email") String email){
        adminService.changeAdminEmail(adminId,email);
    }



}
