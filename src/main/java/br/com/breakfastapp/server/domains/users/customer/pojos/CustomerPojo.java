package br.com.breakfastapp.server.domains.users.customer.pojos;

import lombok.Data;

@Data
public class CustomerPojo {
    private Integer id;

    private String name;

    private String lastName;

    private String password;

    private String cellphone;
}
