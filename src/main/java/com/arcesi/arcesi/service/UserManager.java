package com.arcesi.arcesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcesi.arcesi.model.User;
import com.arcesi.arcesi.repository.IUserRepository;

@Service
public class UserManager {

	@Autowired
	private IUserRepository iur;
	
	public User saveAndFlush(User u) {
		return iur.saveAndFlush(u);
	}
	
	public List<User> findAll() {
		return iur.findAll();
	}
}
