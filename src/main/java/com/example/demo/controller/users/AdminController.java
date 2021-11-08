package com.example.demo.controller.users;

import com.example.demo.DTO.usersDTO.AdminDTO;
import com.example.demo.converter.AdminConverter;
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
    private final AdminConverter converter;

    @GetMapping("/all")
    public List<AdminDTO> getAllAdmins() {
        return converter.entityToDTO(adminService.getAllAdmins());
    }

    @PostMapping(path = "/add")
    public void addNewAdmin(@RequestBody AdminDTO admin){
        adminService.addNewAdmin(converter.dtoToEntity(admin));
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
