package com.employee.client;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.employee.exception.InvalidDetailsException;
import com.employee.model.Employee;
import com.employee.service.EmployeeDetails;
import com.employee.service.IEmployeeDetails;

public class Client {

	static IEmployeeDetails empDetails = new EmployeeDetails();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		char check = 'y';
		Employee emp = new Employee();
		int option;
		do {
			System.out.println("press 1 to add emp");
			System.out.println("press 2 to del emp");
			System.out.println("press 3 to update emp");
			System.out.println("press 4 to view emp");
			System.out.println("press 5 to emp by id");
			System.out.println("press 6 to exit");
			option = scan.nextInt();
			int empId;
			switch (option) {
			case 1: {

				System.out.println("Enter emp name");
				emp.setName(scan.next());

				System.out.println("Enter emp salary");
				emp.setSalary(scan.nextDouble());
				// scan.next();
				try {
					System.out.println(empDetails.addEmp(emp));
					;
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				} catch (InvalidDetailsException e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 2: {
				System.out.println("Enter the emp id you want to delete");
				empId = scan.nextInt();
				try {
					System.out.println(empDetails.delEmp(empId));
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 3: {
				System.out.println("Enter the emp id whose details you want to update:");
				empId = scan.nextInt();
				System.out.println("Enter the new info...");
				
				System.out.println("Enter name:");
				String empNewName = scan.next();
				
				System.out.println("Enter Salary");
				Double empNewSalary = scan.nextDouble();
				
				emp.setId(empId);
				emp.setName(empNewName);
				emp.setSalary(empNewSalary);
				Employee e=null;
				try {
					e = empDetails.updateEmp(empId,emp);
					if(e!=null) {
						System.out.println("new emp details are");
						System.out.println(e);}
						else
							System.out.println("Emp not present with id"+empId);
				} catch (SQLException e1) {
				System.err.println(e1.getMessage());
				} catch (InvalidDetailsException e1) {
					System.err.println(e1.getMessage());
				}
				
				break;
			}
			case 4: {

				List<Employee> empList = null;
				try {
					empList = empDetails.viewEmps();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				if (empList == null)
					System.out.println("List is Empty");
				else {
					for (Employee e : empList) {
						System.out.println(e);
					}

				}
				break;
			}
			case 5:
				System.out.println("enter emp id to find");
				empId=scan.nextInt();
				try {
					emp=empDetails.searchById(empId);
					System.out.println(emp);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				catch(NullPointerException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 6:
				System.out.println("Thank you!");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong option");
			}
			System.out.println();
			System.out.println("do you want to continue?. press y");
			check = scan.next().charAt(0);

		} while (check == 'y');
		System.out.println("Thank You!.");
	}
	
}
