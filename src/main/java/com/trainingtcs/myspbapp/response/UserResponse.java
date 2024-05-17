package com.trainingtcs.myspbapp.response;

import com.trainingtcs.myspbapp.entity.Address;
import jakarta.persistence.Column;

import java.util.List;

public class UserResponse {
	private int id;
	private String name;
	private String role;
	private List<AddressResponse> addresses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<AddressResponse> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressResponse> addresses) {
		this.addresses = addresses;
	}

}
