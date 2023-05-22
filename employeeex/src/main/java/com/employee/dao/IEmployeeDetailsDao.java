package com.employee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.employee.model.Employee;



public interface IEmployeeDetailsDao {
	
	public int addEmp(Employee emp) throws SQLException;
	int delEmp(int empId) throws SQLException;
	List<Employee> viewEmps() throws SQLException;
	public Employee searchEmp(int empId) throws SQLException;
	public Employee updateEmp(int empId,Employee emp) throws SQLException;
}
