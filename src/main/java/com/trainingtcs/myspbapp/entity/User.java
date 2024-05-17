package com.trainingtcs.myspbapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "name")
	private String userName;
	
	@Column(name = "role")
	private String role;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Address> addresses;



}
