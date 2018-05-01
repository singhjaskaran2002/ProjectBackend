package com.jaskaran.project.DAOImplement;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jaskaran.project.DAO.PurchaseOrderDAO;
import com.jaskaran.project.domain.PurchaseOrder;

@Transactional
@Repository("purchaseOrderDAO")
public class PurchaseOrderDAOImplement implements PurchaseOrderDAO
{
	public static Logger log = LoggerFactory.getLogger(PurchaseOrderDAOImplement.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveOrder(PurchaseOrder purchaseOrder) 
	{
		try {
			log.debug("starting of saveOrder method");
			sessionFactory.getCurrentSession().save(purchaseOrder);
			log.debug("ending of saveOrder method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<PurchaseOrder> OrderList(String customeremail) 
	{
		log.debug("getting order list for customer: "+customeremail);
		return sessionFactory.getCurrentSession().createCriteria(PurchaseOrder.class).add(Restrictions.eq("customeremail", customeremail)).list();
	}
	
	public PurchaseOrder getOrderbyEmail(String customeremail) 
	{
		log.debug("getting order details for user: "+customeremail);
		//String hql = "select * from PurchaseOrder where customeremail='"+customeremail+"'";
		return sessionFactory.getCurrentSession().get(PurchaseOrder.class, customeremail);
	}

	public int getOrderID(int token) {				
		int t = (Integer) sessionFactory.getCurrentSession().createSQLQuery("select orderid from Purchaseorder where token="+token).uniqueResult();
		return t;
	}
}
