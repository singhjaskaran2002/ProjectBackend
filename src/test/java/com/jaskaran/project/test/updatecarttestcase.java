package com.jaskaran.project.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.CartDAO;
import com.jaskaran.project.domain.Cart;

public class updatecarttestcase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Cart cart;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");		
	}
	
	@Test
	public void updateCart()
	{
		cart.setQuantity(3);
		
		boolean flag = cartDAO.updateCart(cart);
		assertEquals("update test case", true, flag);
	}

}
