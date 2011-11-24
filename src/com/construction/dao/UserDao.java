package com.construction.dao;

import java.util.List;

import com.construction.model.User;

public interface UserDao {
	public void saveUser(User user) ;
	public List<User> getListUser() ;
	public User findById(Long id);
}


