package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

    @Autowired
    private DataSource dataSource;

    public EmployeeDAOImpl() {
        System.out.println("EmployeeDAOImpl : : 0-param constructor");
    }

    @Override
    public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
        System.out.println("EmployeeDAOImpl.getEmpsByDesgs() --> DS Obj Class Name : : " + dataSource.getClass());

        List<Employee> list = new ArrayList<>();

        // Correct column names based on standard Oracle EMP table
        String sql = "SELECT EMPNO, ENAME, JOB, SAL FROM SCOTT.EMP WHERE JOB IN (?, ?, ?) ORDER BY JOB";


        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters
            ps.setString(1, desg1);
            ps.setString(2, desg2);
            ps.setString(3, desg3);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    // Make sure these column names exist in your EMP table
                    emp.setEno(rs.getInt("EMPNO"));     // EMPNO column
                    emp.setEname(rs.getString("ENAME"));  // ENAME column
                    emp.setDesg(rs.getString("JOB"));      // JOB column
                    emp.setSalary(rs.getDouble("SAL"));   // SAL column
                    list.add(emp);
                }
            }
        }

        return list;
    }
}
