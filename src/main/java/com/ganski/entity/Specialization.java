package com.ganski.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Specialization {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Doctor_Id", nullable = false)
    private Doctor doctor;
}
