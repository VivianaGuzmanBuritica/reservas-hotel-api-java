package com.example.workshopreservas.exception;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String messageError){
        super(messageError);
    }
    public ApiRequestException(String messageError, Throwable cause) {
        super(messageError, cause);
    }
}
