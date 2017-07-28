package com.model;

public class SuperAdmin {
	private String id;
    private String password;
    private String name;
    private String telephone;
    private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SuperAdmin [id=" + id + ", password=" + password + ", name=" + name + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}
    
    
    
}
