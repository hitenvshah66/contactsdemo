package com.contacts.contactsdemo.model;

	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

	public interface ContactRespository extends JpaRepository<Contact, Long> {
	
		
		List<Contact> findByUserName(String userName);		
	}






