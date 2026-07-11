package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.Admin;
import com.example.myflightdb.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServices adminServices;

    @GetMapping("/adminDetails")
    List<Admin> getAllDetails(){return adminServices.getAllAdmins();}

    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin){return adminServices.addAdmin(admin);}

    @PutMapping("/update/{id}")
    public Admin updateById(@PathVariable Integer id,@RequestBody Admin admin){
        return adminServices.updateAdmin(id,admin);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        adminServices.deleteAdmin(id);
        return "deleted successfully";
    }
}
