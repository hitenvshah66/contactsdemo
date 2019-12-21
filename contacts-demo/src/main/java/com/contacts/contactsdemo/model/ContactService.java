package com.contacts.contactsdemo.model;

	import lombok.RequiredArgsConstructor;	

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Service;	

import java.util.List;
import java.util.Optional;
	
	@Service
	@RequiredArgsConstructor
	public class ContactService {
		
		private final Log logger = LogFactory.getLog(WebSecurityConfigurerAdapter.class);
		
		@Autowired
	    private ContactRespository contactRespository;
	
	    public List<Contact> findAll() {
	        return contactRespository.findAll();
	    }

	    public List<Contact> findByUserName(String userName) {
	        return contactRespository.findByUserName(userName);
	    }

	    public Optional<Contact> findById(Long id) {
	        return contactRespository.findById(id);
	    }
	
	    public Contact save(Contact contact) {
	        return contactRespository.save(contact);
	    }
	
	    public void deleteById(Long id) {
	        contactRespository.deleteById(id);
	    }
	}