package com.example.myflightdb.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    private Integer admin_id;
    private String admin_name;
    private String phone_no;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    public Integer getAdmin_id(){return admin_id;}

    public void setAdmin_id(Integer admin_id){this.admin_id=admin_id;}

    @Column(name = "admin_name",nullable = false)
    public String getAdmin_name(){return admin_name;}

    public void setAdmin_name(String admin_name){this.admin_name=admin_name;}

    @Column(name = "phone_no",nullable = false,unique = true)
    public String getPhone_no(){return phone_no;}
    public void setPhone_no(String phone_no){this.phone_no=phone_no;}

    @Column(name = "email",nullable = false,unique = true)
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

}
