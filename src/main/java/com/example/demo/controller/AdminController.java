package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.model.users.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.service.MonumentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/admins")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
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

    @PutMapping(path = "/update/{adminId}")
    public void updateAdmin(@PathVariable("adminId") String adminId,
                            @RequestBody(required = false) Profile profile,
                            @RequestParam(required = false) String position){
        adminService.updateAdmin(adminId,profile,position);
    }

    @PutMapping(path = "/change-password/{adminId}")
    public void changeAdminPassword(@PathVariable("adminId") String adminId,
                                    @RequestParam String password){
        adminService.changeAdminPassword(adminId,password);
    }
}
