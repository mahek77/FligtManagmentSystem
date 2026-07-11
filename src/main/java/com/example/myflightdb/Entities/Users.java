package com.example.myflightdb.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    private Integer user_id;
    private String full_name;
    private String email;
    private String phone_no;
    private String cnic;
    private String passport_no;
    private String nationality;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUser_id(){return user_id;}
    public void setUser_id(Integer user_id){this.user_id=user_id;}

    @Column(name = "full_name",nullable = false)
    public String getFull_name(){return full_name;}
    public void setFull_name(String full_name){this.full_name=full_name;}

    @Column(name = "email",nullable = false,unique = true)
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    @Column(name = "phone_no",nullable = false,unique = true)
    public String getPhone_no(){return phone_no;}
    public void setPhone_no(String phone_no){this.phone_no=phone_no;}

    @Column(name = "cnic",nullable = false,unique = true)
    public String getCnic(){return cnic;}
    public void setCnic(String cnic){this.cnic=cnic;}

    @Column(name = "passport_no",unique = true)
    public String getPassport_no(){return passport_no;}
    public void setPassport_no(String passport_no){this.passport_no=passport_no;}

    @Column(name = "nationality",nullable = false,unique = true)
    public String getNationality(){return nationality;}
    public void setNationality(String nationality){this.nationality=nationality;}
}
