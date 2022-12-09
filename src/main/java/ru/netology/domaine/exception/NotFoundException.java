package ru.netology.domaine.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String s) {
        super(s);
    }
}
