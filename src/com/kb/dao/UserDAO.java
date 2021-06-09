package com.kb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kb.model.User;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class UserDAO {
	static HashMap<String, User> usersMap = new HashMap<String, User>();

	public UserDAO() {
	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>(usersMap.values());
		return userList;
	}

	public User getUserForId(String id) {
		User user = usersMap.get(id);
		return user;
	}

	public User createUser(User user) {
		usersMap.put(user.getId(), user);
		return usersMap.get(user.getId());
	}

	public User updateUser(User user) {
		User existingUser= usersMap.get(user.getId());
		if (existingUser != null) {
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setCountry(user.getCountry());
		} else {
			usersMap.put(user.getId(), user);
		}
		return usersMap.get(user.getId());
	}

	public User deleteUser(String id) {
		User userResponse = usersMap.remove(id);
		return userResponse;
	}

}
