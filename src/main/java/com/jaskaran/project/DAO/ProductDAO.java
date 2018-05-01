package com.jaskaran.project.DAO;

import java.util.List;

import com.jaskaran.project.domain.Product;
import com.jaskaran.project.domain.Supplier;

public interface ProductDAO 
{
	public boolean saveProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean delete(String pid);
	public List<Product> productList();
	public Product getProduct(String pid);
	public List<Product> searchProduct(String searchString);
}