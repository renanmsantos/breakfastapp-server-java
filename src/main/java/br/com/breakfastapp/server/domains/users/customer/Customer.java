package br.com.breakfastapp.server.domains.users.customer;

import br.com.breakfastapp.server.domains.users.customer.enuns.GroupRole;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    private CustomerGroup customerGroup;

    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    private Boolean active;

}
