package com.jaskaran.project.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaskaran.project.domain.Cart;

@Component
public interface CartDAO {

	public Cart getCartbyID(int cartid);
	public boolean saveCart(Cart cart);
	/*public boolean changeStatus(int cartid);*/
	public boolean updateCart(Cart cart);
	//public List<Cart> getCart(String useremail);
	public List<Cart> CartList(String useremail);
	public boolean deleteFromCart(int cartid);
	public boolean deleteCart(String useremail);
	public int getCartQuantity(int cartid);
	
}
