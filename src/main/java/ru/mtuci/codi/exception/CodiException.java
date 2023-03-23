package ru.mtuci.codi.exception;

public class CodiException extends RuntimeException {
    public CodiException(String message) {
        super("Codi Exception: " + message);
    }
}
