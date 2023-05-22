package com.employee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.employee.dao.EmployeeDetailsDao;
import com.employee.dao.IEmployeeDetailsDao;
import com.employee.exception.InvalidDetailsException;
import com.employee.model.Employee;
import com.employee.util.EmpDetailsValidation;

public class EmployeeDetails implements IEmployeeDetails {

	
	List<Employee> empList = new ArrayList<Employee>();
	IEmployeeDetailsDao employeeDetailsDao=new EmployeeDetailsDao();
	EmpDetailsValidation validate=new EmpDetailsValidation();
	Employee employee;
	
	

	public String addEmp(Employee emp) throws SQLException, InvalidDetailsException {
		 employee = new Employee();
		employee=validate.setEmpDetails(emp.getName(),emp.getSalary());
//		employee.setId(emp.getId());
//		employee.setName(emp.getName());
//		employee.setSalary(emp.getSalary());
		int i=employeeDetailsDao.addEmp(employee);
		if(i>0)
		return i+"Row Affected. Employee added Successfully";
		else
			return "Employee not added";
	}

	public String delEmp(int empId) throws SQLException {
		int i=employeeDetailsDao.delEmp(empId);
		if(i>0)
		return "Emp is deleted successfully";
		else
			return "Emp not deleted";
	}

	public Employee updateEmp(int empId,Employee emp) throws SQLException, InvalidDetailsException {
		
		employee=new Employee();
		employee=validate.setEmpDetails(emp.getName(),emp.getSalary());
		
		employee=employeeDetailsDao.updateEmp(empId,employee);
		return employee;
	}

	public List<Employee> viewEmps() throws SQLException {
		List<Employee> empList= employeeDetailsDao.viewEmps();
		if(!empList.isEmpty())
		return empList;
		else 
			return null;
	}
	
	public Employee searchById(int empId) throws SQLException{
		 Employee emp=employeeDetailsDao.searchEmp(empId);
		if(emp!=null)
		return emp;
		else
			throw new NullPointerException("no emp present with id"+empId); 
		
	}

}
