package com.ganski.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Office {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "offices")
    private List<Doctor> doctors;
}
