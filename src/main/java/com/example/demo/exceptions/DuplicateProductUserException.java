package com.example.demo.exceptions;

public class DuplicateProductUserException extends Exception{
    public DuplicateProductUserException(String message){
        super(message);
    }

    public DuplicateProductUserException(String message, Throwable throwable){
        super(message,throwable);
    }
}
