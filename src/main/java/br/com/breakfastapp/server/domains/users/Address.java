package br.com.breakfastapp.server.domains.users;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer addressId;

    @Column
    @NotNull
    private String street;

    @Column
    @NotNull
    private Integer number;

    @Column
    @NotNull
    private String district;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String cep;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;

    @Column
    @NotNull
    private Boolean active;

}
