package com.example.myflightdb.services;

import com.example.myflightdb.Entities.Users;
import com.example.myflightdb.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers(){return usersRepository.findAll();}
    public Users addUser(Users users){
        Optional<Users> existing = usersRepository.findByEmail(users.getEmail());

        if (existing.isPresent()){
            return existing.get();
        }

        return usersRepository.save(users);
    }

    public Users userByEmail(String email){return usersRepository.findByEmail(email)
            .orElseThrow(()-> new RuntimeException("User not Found"));
    }

    public Users userById(Integer id){return usersRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("User not Found"));
    }
}
