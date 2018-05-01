package com.jaskaran.project.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.UserDAO;
import com.jaskaran.project.domain.User;


public class UserTestCase
{

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	
	@Test
	public void saveUserTestCase()
	{		
		user.setEmail("singhjaskaran@gmail.com");
		user.setMobile("9711131492");
		user.setUsername("Jaskaran Singh");
		user.setPassword("jaskaran");
		user.setRole('A');
		user.setRegistrationdate(new Date());
		user.setAddress("House No. 2, Prahladpur, Delhi Cantt.");
		user.setPincode(110010);
		
		boolean flag = userDAO.saveUser(user);
		assertEquals("add user test case", true, flag);
	}
}
