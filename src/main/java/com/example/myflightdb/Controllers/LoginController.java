package com.example.myflightdb.Controllers;

import com.example.myflightdb.Entities.Login;
import com.example.myflightdb.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServices loginServices;

    @PostMapping
    public Login login(@RequestParam String username,@RequestParam String password){
        return loginServices.login(username,password);
    }

    @PostMapping("/add")
    public Login addLogin(@RequestBody Login login){
        return loginServices.addLogin(login);
    }

    @PostMapping("/signup")
    public Login signup(@RequestParam String username,@RequestParam String password){
        return loginServices.signup(username, password);
    }
}
