package br.com.breakfastapp.server.domains.products.pojos;

import lombok.Data;

@Data
public class ProductPojo {
    private String name;
    private Float price;
    private String urlImage;
    private Integer daysProduce;
    private Boolean available;
    private Integer quantity;
    private Integer categoryId;
    private Integer partnerId;
}
