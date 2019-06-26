package br.com.breakfastapp.server.domains.products;

import br.com.breakfastapp.server.domains.users.partner.Partner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Float price;
    private String urlImage;
    private Integer daysProduce;
    private Boolean isAvailable;
    private Integer quantity;
    private Category category;
    private Partner partner;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
