package com.ganski.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Visit {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Date_Time", nullable = false)
    private Date dateTime;

    @Column(name = "Number", nullable = false)
    private int number;

    @OneToOne
    @JoinColumn(name = "Doctor_Id", nullable = false)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "Office_Id", nullable = false)
    private Office office;
}
