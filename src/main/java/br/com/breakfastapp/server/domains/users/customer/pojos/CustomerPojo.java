package br.com.breakfastapp.server.domains.users.customer.pojos;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import lombok.Data;

import java.util.List;

@Data
public class CustomerPojo {
    private Integer id;

    private String name;

    private String lastName;

    private String password;

    private String cellphone;

    private List<Address> addresses;
}
