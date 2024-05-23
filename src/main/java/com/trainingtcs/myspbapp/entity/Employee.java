package com.trainingtcs.myspbapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "dep_id")
    private Department department;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "emp_name")
    private String employeeName;

}
