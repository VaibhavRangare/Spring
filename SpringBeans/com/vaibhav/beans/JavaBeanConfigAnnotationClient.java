package com.vaibhav.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBeanConfigAnnotationClient {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		EntityInt entity = context.getBean("entityOne", EntityInt.class);

		System.out.println(entity.createUser());

		System.out.println(entity.deleteUser());

		System.out.println(entity.getUser());

		System.out.println(entity.getName());

		System.out.println(entity.getDept());

		context.close();

	}

}
