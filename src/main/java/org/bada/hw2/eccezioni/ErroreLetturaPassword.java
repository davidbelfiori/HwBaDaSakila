package org.bada.hw2.eccezioni;

public class ErroreLetturaPassword extends RuntimeException {
    public ErroreLetturaPassword(String message) {
        super(message);
    }
}
