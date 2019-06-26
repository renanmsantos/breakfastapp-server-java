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

    private Integer number;
    private String district;
    private String city;
    private String cep;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
