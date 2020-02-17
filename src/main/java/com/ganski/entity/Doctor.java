package com.ganski.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Medical_Number")
    private String medicalNumber;

    @Column(name = "Medical_Title")
    private String medicalTitle;

    @Column(name = "Specialization")
    private String specialization;

    @OneToOne
    @JoinColumn(name = "User_Id")
    private User user;
}
