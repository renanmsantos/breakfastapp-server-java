package br.com.breakfastapp.server.domains.users;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String street;

    @NotNull
    private Integer number;

    @NotNull
    private String district;

    @NotNull
    private String city;

    @NotNull
    private String cep;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    private Boolean active;

    public Address() {}

    public Address(@NotNull String street, @NotNull Integer number, @NotNull String district, @NotNull String city, @NotNull String cep, @NotNull Boolean active) {
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.cep = cep;
        this.active = active;
    }
}
