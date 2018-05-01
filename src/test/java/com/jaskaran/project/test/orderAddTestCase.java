package com.jaskaran.project.test;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jaskaran.project.DAO.PurchaseOrderDAO;
import com.jaskaran.project.domain.PurchaseOrder;

public class orderAddTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static PurchaseOrder purchaseOrder;
	
	@Autowired
	private static PurchaseOrderDAO purchaseOrderDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran.project");
		context.refresh();
		purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		purchaseOrder = (PurchaseOrder)context.getBean("purchaseOrder");		
	}
	
	@Test
	public void orderAddTest()
	{
		purchaseOrder.setCustomeremail("singhjaskaran@gmail.com");
		purchaseOrder.setCustomermobile("9711131492");
		purchaseOrder.setCustomername("Jaskaran Singh");
		purchaseOrder.setOrderdate(new Date());
		purchaseOrder.setProductname("jordan");
		
		purchaseOrder.setPincode(141104);
		purchaseOrder.setShippingaddress("Delhi cantt");
		
		boolean flag = purchaseOrderDAO.saveOrder(purchaseOrder);
		assertEquals("Add order test case", true, flag);
	}

}
