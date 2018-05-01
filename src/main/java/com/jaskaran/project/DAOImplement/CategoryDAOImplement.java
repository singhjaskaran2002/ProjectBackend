package com.jaskaran.project.DAOImplement;



import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jaskaran.project.DAO.CategoryDAO;
import com.jaskaran.project.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImplement implements CategoryDAO
{
	
	public static Logger log = LoggerFactory.getLogger(CategoryDAOImplement.class);
	
	@Autowired
	SessionFactory sessionFactory;


	public boolean deleteCategory(String cid) {
		try {
			log.debug("starting of deleteCategory method");
			sessionFactory.getCurrentSession().delete(getCategory(cid));
			log.debug("ending of deleteCategory method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in deleting category");
			return false;
		}
	}

	public Category getCategory(String cid) {
		log.debug("getting category details for :"+cid);
		return sessionFactory.getCurrentSession().get(Category.class, cid);
	}

	public List<Category> getCategoriesList() {
		log.debug("printing category list");
		//return	sessionFactory.getCurrentSession().createQuery("from Category").list();
		return (List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	public boolean saveCategory(Category category) {
		try {
			log.debug("starting of saveCategory method");
			sessionFactory.getCurrentSession().save(category);
			log.debug("ending of saveCategory method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in saving category");
			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			log.debug("starting of updateCategory method");
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			log.debug("ending of updateCategory method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in updating category");
			return false;
		}
	}
}
