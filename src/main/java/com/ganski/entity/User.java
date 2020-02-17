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

    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @Column(name = "Surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "Identifier", nullable = false, unique = true, length = 6)
    private String identifier;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Birthday", nullable = false)
    private Date birthday;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "Access_Level", nullable = false)
    private int accessLevel;
}
