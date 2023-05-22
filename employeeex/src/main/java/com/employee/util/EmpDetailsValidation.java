package com.employee.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.employee.exception.InvalidDetailsException;
import com.employee.model.Employee;

public class EmpDetailsValidation {
	private static Integer employeeId=1000;
	Employee emp ;
	
	boolean validateName(String name) {
		Pattern pattern = Pattern.compile("[A-Z][a-zA-Z]{2,}");
		Matcher matcher = pattern.matcher(name);
		return matcher.matches() ? true : false;

	}

	boolean validateSalary(double salary) {
		if (salary < 3000)
			return false;
		else
			return true;
	}

	public Employee setEmpDetails(String name, double salary) throws InvalidDetailsException {
		
		emp = new Employee();

		if (validateName(name))
			emp.setName(name);
		else
			throw new InvalidDetailsException("invalid name");

		if (validateSalary(salary))
			emp.setSalary(salary);
		else
			throw new InvalidDetailsException("salary must be more than 3000");

		
		return emp;
	}

	
}
