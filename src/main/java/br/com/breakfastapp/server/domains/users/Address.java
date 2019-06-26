package br.com.breakfastapp.server.domains.users;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
