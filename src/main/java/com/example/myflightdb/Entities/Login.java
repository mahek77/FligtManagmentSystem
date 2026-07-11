package com.example.myflightdb.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    private Integer loginid;
    private String username;
    private String password;
    private String role;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "loginid")
public Integer getLoginid(){return loginid;}
public void setLoginid(Integer loginid){this.loginid=loginid;}

@Column(name = "username",nullable = false,unique = true)
public String getUsername(){return username;}
public void setUsername(String username){this.username=username;}

@Column(name = "password",nullable = false)
public String getPassword(){return password;}
public void setPassword(String password){this.password=password;}

@Column(name = "role",nullable = false)
public String getRole(){return role;}
public void setRole(String role){this.role=role;}
}


