package com.jaskaran.project.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jaskaran.project.DAO.SupplierDAO;
import com.jaskaran.project.domain.Supplier;

public class SupplierTestCase 
{
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
	
	@Test
	public void saveSupplierTestCase()
	{
		supplier.setSaddress("Delhi Cantt.");
		supplier.setSid("EC001");
		supplier.setSname("E-cart");
		
		boolean flag = supplierDAO.saveSupplier(supplier);
		assertEquals("Save supplier test case", true, flag);
	}
}