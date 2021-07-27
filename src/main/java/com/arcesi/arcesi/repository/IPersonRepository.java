package com.arcesi.arcesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcesi.arcesi.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

	public Person saveAndFlush(Person p);
	
	public List<Person> findAll();
}
