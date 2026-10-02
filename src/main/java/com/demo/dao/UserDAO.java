package com.demo.dao;

import java.util.List;

import com.demo.dto.User;

public interface UserDAO {

	public void registerUser(User user);

	public User getUserByEmail(String email);

	public void updateUser(User user);

	public void deleteUser(Integer id);

	public User getByUserId(Integer id);

	public List<User> getAllUsers();

}
