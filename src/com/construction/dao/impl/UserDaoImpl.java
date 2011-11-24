package com.construction.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dao.UserDao;
import com.construction.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getListUser(){
		return hibernateTemplate.find("from User");
	}

	@SuppressWarnings("unchecked")
	public User findById(Long id){
		try{
			List<User> listUser = hibernateTemplate.find("from User where id = ? ", id);
			return listUser.get(0);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}



}
