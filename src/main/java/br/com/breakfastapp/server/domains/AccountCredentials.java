package br.com.breakfastapp.server.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCredentials {

    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
