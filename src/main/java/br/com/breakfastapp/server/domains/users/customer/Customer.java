package br.com.breakfastapp.server.domains.users.customer;

import br.com.breakfastapp.server.domains.users.customer.enuns.GroupRole;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private String lastName;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    @NaturalId
    private String cpf;

    @Column
    private String cellphone;

    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    private CustomerGroup customerGroup;

    @Column
    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;

    @Column(updatable = false)
    @CreationTimestamp
    private Calendar createdAt;

    @Column
    @UpdateTimestamp
    private Calendar updatedAt;

    @Column
    private Boolean active = true;

}
