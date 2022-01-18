package com.alkemy.challenge.error;

public class ServiceError extends Exception{

	private static final long serialVersionUID = 1L;

	public ServiceError (String msj){
        super(msj);
    }
}
