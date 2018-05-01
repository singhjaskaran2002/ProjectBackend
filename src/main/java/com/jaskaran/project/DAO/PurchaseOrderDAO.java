package com.jaskaran.project.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.jaskaran.project.domain.PurchaseOrder;

@Component
public interface PurchaseOrderDAO 
{
	public boolean saveOrder(PurchaseOrder purchaseOrder);
	public List<PurchaseOrder> OrderList(String customeremail);
	public PurchaseOrder getOrderbyEmail(String customeremail);
	//public boolean deleteOrder(int orderid);
	public int getOrderID(int token);
}
