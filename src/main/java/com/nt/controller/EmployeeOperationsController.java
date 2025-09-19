package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("empController")
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	public EmployeeOperationsController() {
		System.out.println("EmployeeOperationsController : : 0-param constructor");
	}
	
	public List<Employee> showEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception{
      System.out.println("EmployeeOperationsController.showEmployeesByDesgs()");
      //use service
      List<Employee> list = empService.fetchEmpsByDesgs(desg1, desg2, desg3);
		return list;
	}

}
