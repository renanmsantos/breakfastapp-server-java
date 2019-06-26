package br.com.breakfastapp.server.domains.users.customer;

import br.com.breakfastapp.server.domains.users.customer.enuns.EnumGroupRole;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @NaturalId
    private String cpf;

    private String cellphone;
    private Group group;
    private EnumGroupRole groupRole;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
