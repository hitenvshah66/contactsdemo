package com.contacts.contactsdemo.model;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	
	@Entity
	public class Contact {
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    private String name;
		    private String email;
		    private String phone;
		    private String address;
		    private String city;
		    private String state;
		    private String zipcode;
		    private String userName;
		    
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getZipcode() {
				return zipcode;
			}
			public void setZipcode(String zipcode) {
				this.zipcode = zipcode;
			}
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
		    
	}
