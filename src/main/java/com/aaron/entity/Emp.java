package com.aaron.entity;

import java.util.Date;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer empNo;
	private String empName;
	private Double empSal;
	private Integer empAge;
	private Integer deptNo;
	private Date birthday;
	
	//增添一方引用，实现多对一
	private Dept dept;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	
	
	public Emp(String empName, Double empSal, Integer empAge, Integer deptNo,
			Date birthday) {
		this.empName = empName;
		this.empSal = empSal;
		this.empAge = empAge;
		this.deptNo = deptNo;
		this.birthday = birthday;
	}

	public Emp(Integer empNo, String empName, Double empSal) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empSal = empSal;
	}

	// Property accessors

	public Integer getEmpNo() {
		return this.empNo;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return this.empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public Integer getEmpAge() {
		return this.empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public Integer getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empSal=" + empSal + ", empAge=" + empAge
				+ ", deptNo=" + deptNo + ", birthday=" + birthday + ", dept=" + dept + "]";
	}

	
	
	

}