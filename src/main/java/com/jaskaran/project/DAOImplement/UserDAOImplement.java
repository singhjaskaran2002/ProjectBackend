package com.jaskaran.project.DAOImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaskaran.project.DAO.UserDAO;
import com.jaskaran.project.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImplement implements UserDAO
{
	public static Logger log = LoggerFactory.getLogger(UserDAOImplement.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public User validateUser(String email, String password) 
	{
		log.debug("validating user to login to system");
		User user;
		user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("email", email))
					.add(Restrictions.eq("password", password)).uniqueResult();
		if(user == null)
		{
			log.debug("invalid credentials");
			return null;
		}
		else
		{
			log.debug("login attempt successfull for user: "+email);
			return user;
		}
	}

	public List<User> Userlist() {
		log.debug("getting user list");
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getUser(String email) {
		log.debug("getting details of user: "+email);
		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	public boolean deleteUser(String email) {
		try {
			log.debug("deleting user: "+email);
			sessionFactory.getCurrentSession().delete(getUser(email));
			return true;
		} catch (Exception e) {
			log.debug("could not deleted");
			return false;
		}	
	}

	public boolean saveUser(User user) {
		try {
			log.debug("starting of the saveUser method");
			sessionFactory.getCurrentSession().save(user);
			log.debug("ending of the saveUser method");
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
	
	public boolean updateUser(User user) {
		try {
			log.debug("starting of the updateUser method");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			log.debug("ending of the updateUser method");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}