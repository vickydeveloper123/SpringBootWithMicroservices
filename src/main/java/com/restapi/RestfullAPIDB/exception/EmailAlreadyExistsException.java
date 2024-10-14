package com.restapi.RestfullAPIDB.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    String message;
    public EmailAlreadyExistsException(String message){

        this.message=message;
    }
}
