package ru.mtuci.codi.exception;

public class CodiValidationException extends CodiException{
    public CodiValidationException(String message) {
        super("Valid Exception: "+message);
    }
}
