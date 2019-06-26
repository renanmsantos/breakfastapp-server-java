package br.com.breakfastapp.server.domains.users.customer;

import br.com.breakfastapp.server.domains.users.customer.enuns.EnumGroupRole;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String cpf;

    private String cellphone;
    private Group group;
    private EnumGroupRole groupRole;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
