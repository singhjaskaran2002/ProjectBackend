package com.jaskaran.project.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.ProductDAO;
import com.jaskaran.project.domain.Product;


public class ProductTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
		
	}
	
	@Test
	public void saveProductTestCase()
	{
		//product.setCategory(Category.);
		//product.setSupplier("E-cart");
		//product.setCdescription("All types of smartphones");
		
		boolean flag = productDAO.saveProduct(product);
		assertEquals("Save product test case",true, flag);
	}

}
