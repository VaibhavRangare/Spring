package com.vaibhav.beans;

public class FirstExternalServiceImp implements ExternalService {

	@Override
	public String getService() {
		return "This is FIRST External Service";
	}

	@Override
	public String getOtherService() {
		return "This is FIRST other External Service";
	}

}
