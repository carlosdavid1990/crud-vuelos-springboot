package com.example.demo.exceptions;


//Excepción cuando un recurso no existe
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
