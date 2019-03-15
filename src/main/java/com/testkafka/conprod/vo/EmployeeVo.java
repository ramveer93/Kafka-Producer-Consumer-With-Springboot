package com.testkafka.conprod.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author sramveer
 */
public class EmployeeVo {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("department")
	private String department;
	@JsonProperty("salary")
	private long salary;
	@JsonProperty("joiningDate")
	private Date joiningDate;

	public EmployeeVo() {

	}

	public EmployeeVo(Integer id, String name, String department, long salary, Date joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getJoiningDate() {
		return joiningDate.toString();
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + "]";
	}

}
