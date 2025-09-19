package com.nt.model;

import lombok.Data;

@Data
public class Employee 
{
	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;
	 
	public Employee()
	{
		System.out.println("Employee : : 0-param constructor");
	}

}
