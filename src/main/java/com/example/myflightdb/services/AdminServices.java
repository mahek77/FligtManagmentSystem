package com.example.myflightdb.services;

import com.example.myflightdb.Entities.Admin;
import com.example.myflightdb.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAllAdmins(){return adminRepository.findAll();}

    public Admin addAdmin(Admin admin){return adminRepository.save(admin);}

    public Admin updateAdmin(Integer Id,Admin admin){
        Admin existing = adminRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        existing.setAdmin_name(admin.getAdmin_name());
        existing.setEmail(admin.getEmail());
        existing.setPhone_no(admin.getPhone_no());

        return adminRepository.save(existing);
    }

    public void deleteAdmin(Integer id){adminRepository.deleteById(id);}
}
