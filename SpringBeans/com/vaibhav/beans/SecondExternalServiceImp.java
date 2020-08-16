package com.vaibhav.beans;

public class SecondExternalServiceImp implements ExternalService {

	@Override
	public String getService() {
		return "This is SECOND External Service";
	}

	@Override
	public String getOtherService() {
		return "This is SECOND other External Service";
	}

}
