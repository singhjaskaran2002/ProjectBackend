package com.jaskaran.project.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.CategoryDAO;
import com.jaskaran.project.domain.Category;

public class getCategoriesTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	//@Autowired	
	//@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		//category = (Category)context.getBean("category");
		
	}
	
	@Test
	public void getCategoriesTest()
	{
		List<Category> list = categoryDAO.getCategoriesList();
		assertEquals("get categories test case", 6, list.size());
		for(Category a:list)
		{
			System.out.println(a.getCid()+"		"+a.getCname()+"	"+a.getCdescription());
		}
	}
}
