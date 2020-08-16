package com.vaibhav.college.db.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vaibhav.college.db.entity.Users;

public class CreateUsers {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new user object...");

			org.springframework.security.crypto.password.PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			String hashedPassword = passwordEncoder.encode("test123");
			hashedPassword = "{bcrypt}" + hashedPassword;
			Users user = new Users("Vaibhav", hashedPassword, 1);
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(user);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
