package com.employee.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import com.employee.exception.InvalidDetailsException;
import com.employee.model.Employee;

public interface IEmployeeDetails {
	
		String addEmp(Employee emp) throws SQLException, InvalidDetailsException;
		String delEmp(int empId) throws SQLException;
		Employee updateEmp(int empId, Employee emp) throws SQLException, InvalidDetailsException;
		List<Employee> viewEmps() throws SQLException;
		public Employee searchById(int empId) throws SQLException ,NullPointerException;
		
}
