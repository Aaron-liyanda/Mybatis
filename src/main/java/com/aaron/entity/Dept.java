package com.aaron.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable{
	
	private Integer deptNo;
	private String name;
	private String location;
	
	private Set<Emp> emps = new HashSet();
	
	
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", name=" + name + ", location=" + location + ", emp=" + emps + "]";
	}
	
	
	

}
