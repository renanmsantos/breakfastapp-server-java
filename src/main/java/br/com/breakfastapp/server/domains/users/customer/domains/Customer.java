package br.com.breakfastapp.server.domains.users.customer.domains;

import br.com.breakfastapp.server.domains.users.address.domains.Address;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private String lastName;

    @Column
    @NotNull
    private String cpf;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    private String cellphone;

    @Column(updatable = false)
    @CreationTimestamp
    private Calendar createdAt;

    @Column
    @UpdateTimestamp
    private Calendar updatedAt;

    @Column
    private Boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Address> addresses;

}
