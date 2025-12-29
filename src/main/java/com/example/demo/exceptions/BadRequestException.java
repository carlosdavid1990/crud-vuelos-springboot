package com.example.demo.exceptions;

//Excepción para peticiones incorrectas
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
