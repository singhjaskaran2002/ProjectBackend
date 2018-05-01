package com.jaskaran.project.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project.DAO.CartDAO;
import com.jaskaran.project.domain.Cart;



public class cartDeleteTestCase {

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
	
	/*@Test
	public void deleteTestCase()
	{
		boolean flag = cartDAO.deleteCart("singhjaskaran@gmail.com");
		assertEquals("delete Cart Test Case", true, flag);
	}*/
	
	@Test
	public void deleteCart()
	{
		List<Cart> carts = cartDAO.CartList("singhjaskaran@gmail.com");
	    System.out.println("Size of List is: "+carts.size());
		for(Cart a:carts)
		{
			System.out.println(a.getCartid()+"         "+a.getProductname());
		}
	}
	
	
}
