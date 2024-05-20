package com.trainingtcs.myspbapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
//streams
//source intermdiary and final operations
//know them by name
//user as adddress
//transformer instead of map
import java.util.Set;
@Data
@Entity
@Table(name = "addresses")
public class Address {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

}
