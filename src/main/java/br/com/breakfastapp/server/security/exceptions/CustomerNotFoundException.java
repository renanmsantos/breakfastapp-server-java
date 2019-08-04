package br.com.breakfastapp.server.security.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String email) {
        super(email);
    }
}
