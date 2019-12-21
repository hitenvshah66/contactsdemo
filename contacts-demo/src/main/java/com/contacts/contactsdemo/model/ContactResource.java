package com.contacts.contactsdemo.model;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.contacts.contactsdemo.error.ContactNotFoundException;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContactResource {

	private final Log logger = LogFactory.getLog(WebSecurityConfigurerAdapter.class);
	
	@Autowired
	private ContactService contactService;
	
    // Find
    @GetMapping("/users/{userName}/contacts")
    public List<Contact> findAll(@PathVariable String userName) {
    	if (userName.equalsIgnoreCase("ADMIN"))
    		return contactService.findAll();
    	else
    		return contactService.findByUserName(userName);
    }

    // Save
    @PostMapping("/users/{userName}/contacts")
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> newContact(@Valid @RequestBody Contact newContact, @PathVariable String userName) {
        newContact.setUserName(userName);
		Contact createdContact = contactService.save(newContact);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}" ).buildAndExpand(createdContact.getId()).toUri();
		return ResponseEntity.created(uri).build();

    }

    // Find
    @GetMapping("/users/{userName}/contacts/{id}")
    public Contact findOne(@PathVariable @Min(1) Long id,@PathVariable String userName) {
        return contactService.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    // Save or update
    @PutMapping("/users/{userName}/contacts/{id}")
    public ResponseEntity<Contact> saveOrUpdate(@RequestBody Contact newContact, @PathVariable Long id,@PathVariable String userName) {
    	newContact.setUserName(userName);
		Contact ContactUpdated = contactService.save(newContact);
		return new ResponseEntity<Contact>(ContactUpdated, HttpStatus.OK);
    }


    @DeleteMapping("/users/{userName}/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id, @PathVariable String userName ) {
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
}
