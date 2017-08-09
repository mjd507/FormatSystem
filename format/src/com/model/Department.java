package com.model;

public class Department {
    private Integer id;

    private String name;

    private Integer oId;
 
    //
    private String oName;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", oId=" + oId + ", oName=" + oName + "]";
	}

    
}