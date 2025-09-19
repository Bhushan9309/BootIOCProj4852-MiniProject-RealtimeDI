package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO empDAO;
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl : : 0-param constructor");
	}
	
   @Override
	public List<Employee> fetchEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
	   System.out.println("EmployeeMgmtServiceImpl.fetchEmpsByDesgs()");
		// convert given  desgs to uppercase  letters (business logic)
	   desg1=desg1.toUpperCase();
	   desg2=desg2.toUpperCase();
	   desg3=desg3.toUpperCase();
	   //use DAO
	   List<Employee> list = empDAO.getEmpsByDesgs(desg1, desg2, desg3);
	   //calculate grossSalary and net Salary
	   list.forEach(emp->{
		   emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.5));
		   emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
	   });
		return list;
	}

}
