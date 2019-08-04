package br.com.breakfastapp.server.security.domains;

public class UserInformation {
    private String token;
    private Object customer;

    public UserInformation(String token, Object customer) {
        this.token = token;
        this.customer = customer;
    }
}
