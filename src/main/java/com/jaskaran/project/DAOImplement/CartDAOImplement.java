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

import com.jaskaran.project.DAO.CartDAO;
import com.jaskaran.project.domain.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOImplement implements CartDAO
{
	public static Logger log = LoggerFactory.getLogger(CartDAOImplement.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Cart> CartList(String useremail) {
		log.debug("displaying the list of cart sending username as parameter");
		return sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("useremail", useremail)).list();
	}

	public boolean deleteFromCart(int cartid) {
		
		try {
			log.debug("starting of method delete");
			sessionFactory.getCurrentSession().delete(getCartbyID(cartid));
			log.debug("delete cart method ended");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.debug("error occured in deleting item from cart");
			e.printStackTrace();
			return false;
		}
	}

	public boolean saveCart(Cart cart) {
		try {
			log.debug("starting of save cart method");
			sessionFactory.getCurrentSession().save(cart);
			log.debug("ending of save cart method");
			return true;
		} catch (Exception e) {
			log.debug("error in saving cart");
			return false;
		}
	}
	
	public Cart getCartbyID(int cartid) {
		log.debug("getting cart details for cartid: "+cartid);
		return sessionFactory.getCurrentSession().get(Cart.class, cartid);
	}

	public boolean statusUpdate(String useremail) {
		String hql = "update Cart set status = 'O' where useremail='" + useremail + "'";
		
		try
		{
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		log.debug("updated status of cart for user: "+useremail);
		return true;
		}
		catch (Exception e) {
			log.debug("error occured in updating status");
			return false;
		}
	}

	public boolean deleteCart(String useremail) {
		
		String hql="delete from Cart where useremail='"+useremail+"'";
		try {
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			log.debug("cart deleted of user: "+useremail);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.debug("error occured in deleting cart for user: "+useremail);
			return false;
		}
	}

	public int getCartQuantity(int cartid) {
		//String hql="select cartquantity from Cart where cartid="+cartid;
		try {
			int qty = (Integer) sessionFactory.getCurrentSession().createSQLQuery("select quantity from Cart where cartid="+cartid).uniqueResult();
			System.out.println(qty);
			return qty;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
