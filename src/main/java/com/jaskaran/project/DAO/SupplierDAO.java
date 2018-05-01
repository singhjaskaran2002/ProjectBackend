package com.jaskaran.project.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.jaskaran.project.domain.Supplier;

@Component
public interface SupplierDAO 
{
	public boolean saveSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(String sid);
	public List<Supplier> getSupplierList();
	public Supplier getSupplier(String sid);
}