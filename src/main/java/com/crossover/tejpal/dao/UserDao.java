package com.crossover.tejpal.dao;

import java.util.List;

import com.crossover.tejpal.model.Test;
import com.crossover.tejpal.model.User;

public interface UserDao {

	public void addUser(User user);

	public void updateUser(User user);

	public List<User> listUsers();

	public User getUserById(int id);

	public User getUserByName(String id);

	public void removeUser(int id);

	public void createTest(Test t);
}
