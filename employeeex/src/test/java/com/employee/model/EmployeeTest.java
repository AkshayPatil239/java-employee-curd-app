package com.employee.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;

public class EmployeeTest {
	Employee emp;
	
	
	@Before
	public void startUp() {
		emp=new Employee();
	}
	
	@After
	public void end() {
		emp=null;
	}
	
	

	@Test
	public void testGetId() {
		emp.setId(5);
		assertEquals(5,emp.getId());
		
	}

	@Test
	public void testSetId() {
		
      emp.setId(5);
      assertEquals(5,emp.getId());
		
	}

	@Test
	public void testGetName() {
		emp.setName("SagarPatil");
		assertEquals("SagarPatil",emp.getName());
	}

	@Test
	public void testSetName() {
		emp.setName("Aakashpatil");
		assertEquals("Aakashpatil",emp.getName());
		
	}

	@Test
	public void testGetSalary() {
		emp.setSalary(4000);
		assertEquals(4000.0,emp.getSalary(),0.0);
	}

	@Test
	public void testSetSalary() {
		emp.setSalary(4000);
		
		assertEquals(4000.0,emp.getSalary(),0.0);
	}

}
