package com.jaskaran.project.DAO;

import java.util.List;


import org.springframework.stereotype.Component;
import com.jaskaran.project.domain.Category;

@Component
public interface CategoryDAO 
{
	public boolean saveCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(String cid);
	public List<Category> getCategoriesList();
	public Category getCategory(String cid);
}