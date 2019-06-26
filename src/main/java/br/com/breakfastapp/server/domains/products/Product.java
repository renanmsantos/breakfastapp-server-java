package br.com.breakfastapp.server.domains.products;

import br.com.breakfastapp.server.domains.users.partner.Partner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    private Float price;
    private String urlImage;
    private Integer daysProduce;
    private Integer quantity;

    @NotNull
    private Boolean available;

    @NotNull
    private Category category;

    @NotNull
    private Partner partner;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
