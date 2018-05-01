package com.jaskaran.project.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.UserDAO;
import com.jaskaran.project.domain.User;

public class updateUserTestCase {

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
	public void updateUserTest()
	{
		user.setPassword("manindersingh");
		boolean flag = userDAO.updateUser(user);
		assertEquals("update user test case", true, flag);
	}
}
