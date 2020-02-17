package com.ganski.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class User {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Identifier")
    private String identifier;

    @Column(name = "Password")
    private String password;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Access_Level")
    private int accessLevel;
}
