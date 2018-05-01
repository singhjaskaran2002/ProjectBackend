package com.jaskaran.project.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.UserDAO;
import com.jaskaran.project.domain.User;

public class getUserTestCase {


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
	public void getUserTestCase()
	{
		User u = userDAO.getUser("singhjaskaran@gmail.com");
		System.out.println(u.getEmail()+"	"+u.getUsername()+"	"+u.getMobile());
	}

}
