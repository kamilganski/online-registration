package com.ganski.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
public class Visit {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Date_Time")
    private Date dateTime;

    @Column(name = "Number")
    private int number;

    @OneToOne
    @JoinColumn(name = "Doctor_Id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @OneToOne
    @JoinColumn(name = "Office_Id")
    private Office office;
}
