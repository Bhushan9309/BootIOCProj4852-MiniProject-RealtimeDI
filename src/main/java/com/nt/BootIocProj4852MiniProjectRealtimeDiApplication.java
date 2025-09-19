package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj4852MiniProjectRealtimeDiApplication {

	public static void main(String[] args) {
		try( ConfigurableApplicationContext ctx = SpringApplication.run(BootIocProj4852MiniProjectRealtimeDiApplication.class, args);
                Scanner sc= new Scanner(System.in);
				){
			//read the desgs from end user
	     System.out.println("Enter Desingation1 : : ");
	     String desg1 =sc.next();
	     System.out.println("Enter Desingation2 : : ");
	     String desg2 =sc.next();
	     System.out.println("Enter Desingation3 : : ");
	     String desg3 =sc.next();
	     //get Controller class object
	     EmployeeOperationsController controller =
	    		 ctx.getBean("empController",EmployeeOperationsController.class);
	     //invoke business method
	     List<Employee> list = controller.showEmployeesByDesgs(desg1, desg2, desg3);
	     //process the result
	     System.out.println("Employee having " +desg1+ "----"+desg2+"-----"+desg3);
	     
	     if(list.size()!=0) {
	     list.forEach(emp->{
	    	 System.out.println(emp);
	     });
	     }
	     else {
	    	 System.out.println("No Employees Found");
	     }
	     
	     
		}
		catch (Exception e) {
			System.out.println("Internal Problem : : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
