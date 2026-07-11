package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.Users;
import com.example.myflightdb.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserServices userServices;

    @GetMapping
    public List<Users> getAllUsers(){return userServices.getAllUsers();}

    @PostMapping("/add")
    public Users addUser(@RequestBody Users users){return userServices.addUser(users);}

    @GetMapping("/{id}")
    public Users userById(@PathVariable Integer id){return userServices.userById(id);}

    @GetMapping("/{email}")
    public Users userByEmail(@PathVariable String email){return userServices.userByEmail(email);}

}
