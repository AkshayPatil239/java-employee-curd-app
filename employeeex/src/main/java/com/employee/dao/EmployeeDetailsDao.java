package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.employee.model.Employee;

public class EmployeeDetailsDao implements IEmployeeDetailsDao{
	
	Connection con=null;
	PreparedStatement stmt=null;
	Employee emp1;
	
	public EmployeeDetailsDao() {
		
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","root");
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		
	}

	@Override
	public int addEmp(Employee emp) throws SQLException {

		stmt=con.prepareStatement("insert into emp4 (name,salary) values (?,?)");
		//stmt.setInt(1,emp.getId());
		stmt.setString(1,emp.getName());
		stmt.setDouble(2,emp.getSalary());
		
		int i=stmt.executeUpdate();
		
		return i;
	}

	@Override
	public int delEmp(int empId) throws SQLException {
		stmt=con.prepareStatement("delete from emp4 where id=?");
		stmt.setInt(1, empId);
		int i=stmt.executeUpdate();
		
		return i;
	}

	@Override
	public Employee updateEmp(int empId,Employee emp) throws SQLException {
		stmt=con.prepareStatement("update emp4 set name=?,salary=? where id=?");
		stmt.setString(1,emp.getName());
		stmt.setDouble(2,emp.getSalary());
		stmt.setInt(3,empId);
		int i=stmt.executeUpdate();
		ResultSet rs;
		if(i>0)
		 {
			
			stmt=con.prepareStatement("select * from  emp4  where id=?");
			stmt.setInt(1,empId);
			rs=stmt.executeQuery();

			while(rs.next())
			{
				emp1=new Employee();
				emp1.setId(rs.getInt(3));
				emp1.setName(rs.getString(1));
				emp1.setSalary(rs.getDouble(2));			
			}
			return emp1;
		}
		else
		return null;
	}

	@Override
	public List<Employee> viewEmps() throws SQLException {
		ArrayList<Employee> list=new ArrayList<Employee>();
		ResultSet rs;
	
		stmt=con.prepareStatement("select * from emp4");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			emp1=new Employee();
			emp1.setId(rs.getInt(3));
			emp1.setName(rs.getString(1));
			emp1.setSalary(rs.getDouble(2));
			list.add(emp1);
					
		}
		
		return list;
	}
	
	public Employee searchEmp(int empId) throws SQLException {
		stmt=con.prepareStatement("select * from emp4 where id=?");
		stmt.setInt(1,empId);
		ResultSet rs;
		rs=stmt.executeQuery();
		
		while(rs.next())
		{
			emp1=new Employee();
			emp1.setName(rs.getString(1));
			emp1.setSalary(rs.getDouble(2));
			emp1.setId(rs.getInt(3));
					
		}
		
		if(emp1!=null)
		return emp1;
		else
			return null;
		
		
	}
	

}
