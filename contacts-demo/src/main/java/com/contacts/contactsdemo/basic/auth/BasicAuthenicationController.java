package com.contacts.contactsdemo.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenicationController {

	@GetMapping( path ="/basicauth")
	public AuthencationBean basicAuthenticationBean() {
		return new AuthencationBean("You are authenticated.");
	}
}
