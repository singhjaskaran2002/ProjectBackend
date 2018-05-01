package com.jaskaran.project.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jaskaran.project.DAO.CartDAO;
import com.jaskaran.project.domain.Cart;

public class cartTestCase 
{
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
	public void saveCartTestCase()
	{
		//cart.setCartid();
		/*cart.setProductid("JORDAN001");
		cart.setProductname("JORDAN");
		cart.setProductprice(5000);
		cart.setQuantity(2);
		cart.setUseremail("singhjaskaran@gmail.com");
		cart.setProductdescription("it very good...");*/
	//	cart.setCartid();
		cart.setProductid("HD001");
		cart.setProductname("HyperDunk");
		cart.setProductprice(3000);
		cart.setQuantity(1);
		cart.setUseremail("singhjaskaran@gmail.com");
		boolean flag = cartDAO.saveCart(cart);
		assertEquals("save Cart Test Case", true, flag);
	}
	
	@Test
	public void main()
	{
		Cart c = cartDAO.getCartbyID(4);
		System.out.println(c.getCartid()+"	"+c.getProductid()+"	"
							+c.getProductdescription()+"	"+c.getProductname()+
							"	"+c.getQuantity()+"	"+c.getUseremail());
	}

}
