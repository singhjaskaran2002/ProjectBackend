package com.jaskaran.project.DAOImplement;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jaskaran.project.DAO.SupplierDAO;

import com.jaskaran.project.domain.Supplier;


@Transactional
@Repository("supplierDAO")
public class SupplierDAOImplement implements SupplierDAO
{
	public static Logger log = LoggerFactory.getLogger(SupplierDAOImplement.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean deleteSupplier(String sid) {
		try {
			log.debug("starting of the deleteSupplier method");
			sessionFactory.getCurrentSession().delete(getSupplier(sid));
			log.debug("ending of the deleteSupplier method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in deleting supplier");
			return false;
		}
	}

	public List<Supplier> getSupplierList() {
		log.debug("getting supplier list");
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public Supplier getSupplier(String sid) {
		log.debug("get supplier details of sid: "+sid);
		return sessionFactory.getCurrentSession().get(Supplier.class, sid);
	}

	public boolean saveSupplier(Supplier supplier) {
		try {
			log.debug("starting of the saveSupplier method");
			sessionFactory.getCurrentSession().save(supplier);
			log.debug("ending of the saveSupplier method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in saving supplier");
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			log.debug("starting of the updateSupplier method");
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			log.debug("ending of the updateSupplier method");
			return true;
		} catch (Exception e) {
			log.debug("error occured in updating supplier");
			return false;
		}
	}
	


}
