package com.jaskaran.project.DAOImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaskaran.project.DAO.ProductDAO;
import com.jaskaran.project.domain.Category;
import com.jaskaran.project.domain.Product;
import com.jaskaran.project.domain.Supplier;

@Transactional
@Repository("productDAO")
public class ProductDAOImplement implements ProductDAO 
{
	public static Logger log = LoggerFactory.getLogger(ProductDAOImplement.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean delete(String pid) {
		try {
			log.debug("starting of deleteProduct method");
			sessionFactory.getCurrentSession().delete(getProduct(pid));
			log.debug("ending of deleteProduct method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in deleting product: "+pid);
			return false;
		}		
	}

	public List<Product> productList() {
		log.debug("getting product list");
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean saveProduct(Product product) {
		try {
			log.debug("starting of saveProduct method");
			sessionFactory.getCurrentSession().save(product);
			log.debug("ending of saveProduct method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in saving product");
			return false;
		}
	}
	
	public boolean updateProduct(Product product) {
		try {
			log.debug("starting of updateProduct method");
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			log.debug("ending of updateProduct method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in updating product");
			return false;
		}
	}

	public Product getProduct(String pid) {
		log.debug("getting product details of id: "+pid);
		return sessionFactory.getCurrentSession().get(Product.class, pid);
	}

	public List<Product> searchProduct(String searchString) {
		log.debug("searching product for search string: "+searchString);
		/*String hql="select * from Product where productdescription like '%" +searchString+ "%'";*/
		return sessionFactory.getCurrentSession().createQuery("from Product where productdescription like '%" +searchString+ "%'").list();
	}
}