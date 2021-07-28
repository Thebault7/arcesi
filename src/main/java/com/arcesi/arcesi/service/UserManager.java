package com.arcesi.arcesi.service;

import java.security.NoSuchAlgorithmException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcesi.arcesi.model.User;
import com.arcesi.arcesi.utils.IWordHashGenerator;
import com.arcesi.arcesi.utils.WordHashGenerator;
import com.arcesi.arcesi.repository.IUserRepository;

@Service
public class UserManager {

	@Autowired
	private IUserRepository iur;
//	@Autowired
//	private IWordHashGenerator iwhg;
	
	public User saveAndFlush(User u) {
//		try {
//			IWordHashGenerator iwhg = new WordHashGenerator();
//			u.setPassword(iwhg.generateHash(u.getPassword(), "SHA-512"));
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//			System.out.println("Hashing du mot de passe a échoué.");
//		}
		u.setPassword("6473439242529538572345");
		return iur.saveAndFlush(u);
	}
	
	public List<User> findAll() {
		return iur.findAll();
	}
	
	public User findOneByUserName(String userName) {
		return iur.findOneByUserName(userName);
	}
}
