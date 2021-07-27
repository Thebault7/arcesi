package com.arcesi.arcesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arcesi.arcesi.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	public User saveAndFlush(User u);
	
	public List<User> findAll();
}
