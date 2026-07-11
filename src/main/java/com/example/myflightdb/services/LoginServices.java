package com.example.myflightdb.services;

import com.example.myflightdb.Entities.Login;
import com.example.myflightdb.Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    @Autowired
    LoginRepository loginRepository;

    public Login login(String username, String password) {
        Login login = loginRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username"));

        if (!login.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return login;
    }

    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }

    public Login signup(String username, String password) {

        if (loginRepository.existsByUsername(username)) {
            throw new RuntimeException("User already exists");
        }

        Login login = new Login();

        login.setUsername(username);
        login.setPassword(password);
        login.setRole("USER");

        return loginRepository.save(login);
    }
}
