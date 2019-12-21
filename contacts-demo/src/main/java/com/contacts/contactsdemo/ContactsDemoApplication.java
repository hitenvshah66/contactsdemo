package com.contacts.contactsdemo;

	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	@SpringBootApplication
	public class ContactsDemoApplication {

		public static void main(String[] args) {
			SpringApplication.run(ContactsDemoApplication.class, args);
		}

		/*
		@Bean
	    CommandLineRunner initDatabase(ContactRespository repository) {
	        return args -> {
	            repository.save(new Contact());
	            repository.save(new Contact());
	            repository.save(new Contact());
	        };
	    }
	    */
	}
