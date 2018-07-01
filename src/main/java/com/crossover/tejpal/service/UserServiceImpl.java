package com.crossover.tejpal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.tejpal.dao.UserDao;
import com.crossover.tejpal.model.Test;
import com.crossover.tejpal.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	static {
		System.out.println("Inclass PersonServiceImpl");
	}

	@Autowired
	private UserDao userDAO;

	public void setUserDAO(UserDao personDAO) {
		this.userDAO = personDAO;
	}

	
	@Override
	@Transactional
	public void addUser(User user) {
		
		this.userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		this.userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public User getUserByName(String id) {
		return this.userDAO.getUserByName(id);
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub

	}


	@Override
	@Transactional
	public void createTestForUser(Test t) {
		this.userDAO.createTest(t);
	}

}
