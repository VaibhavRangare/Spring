package com.vaibhav.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EntityOne implements EntityInt {

	@Autowired
	@Qualifier("firstExternalServiceImp")
	private ExternalService firstExternalServiceImp;

	private ExternalService SecondExternalServiceImp;

	@Value("Vaibhav")
	private String name;

	@Value("${service.stopdaemon}")
	private String dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Autowired
	public EntityOne(ExternalService SecondExternalServiceImp) {
		this.SecondExternalServiceImp = SecondExternalServiceImp;
	}

	public EntityOne() {
		System.out.println("default constructor");
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Performing PreChecks...");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("Performing PostChecks...");
	}

	@Override
	public String createUser() {
		return "Creating User...";
	}

	@Override
	public String deleteUser() {
		System.out.println("Deleteing User...");
		return firstExternalServiceImp.getService();
	}

	@Override
	public String getUser() {
		System.out.println("Get User...");
		return SecondExternalServiceImp.getService();
	}

}
