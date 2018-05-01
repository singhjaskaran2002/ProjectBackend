package com.jaskaran.project.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.UserDAO;
import com.jaskaran.project.domain.User;

public class UserListTest {

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
		public void userListTestCase()
		{
			List<User> u = userDAO.Userlist();
			for(User a:u)
			{
				System.out.println(a.getUsername()+"		"+a.getEmail()+"		"+a.getMobile()+"		"+a.getRegistrationdate());
			}
		}

}
