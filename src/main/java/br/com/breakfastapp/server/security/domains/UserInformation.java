package br.com.breakfastapp.server.security.domains;

import br.com.breakfastapp.server.domains.users.customer.domains.Customer;

public class UserInformation {
    private String token;
    private Object customer;

    public UserInformation(String token, Object customer) {
        this.token = token;
        this.customer = customer;
    }
}
