package com.jaskaran.project.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.CategoryDAO;
import com.jaskaran.project.domain.Category;

public class deleteCategoryTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
		
	}
	
	@Test
	public void saveCategoryTestCase()
	{
		boolean flag = categoryDAO.deleteCategory("MOB001");
		assertEquals("delete category test case", true, flag);
		
	}

}
