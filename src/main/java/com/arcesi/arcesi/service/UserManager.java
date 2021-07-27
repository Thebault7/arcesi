package com.arcesi.arcesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcesi.arcesi.repository.IUserRepository;

@Service
public class UserManager {

	@Autowired
	private IUserRepository iur;
}
