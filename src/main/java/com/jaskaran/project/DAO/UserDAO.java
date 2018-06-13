package com.jaskaran.project.DAO;

import java.util.List;

import com.jaskaran.project.domain.User;

public interface UserDAO 
{
	public boolean saveUser(User user);
	public User validateUser(String email, String password);
    public List<User> Userlist();
	public User getUser(String email);
	public boolean updateUser(User user);
	public boolean deleteUser(String email);
	public User getUserbyMobile(String mobile);
}
