package br.com.breakfastapp.server.domains.products;

import br.com.breakfastapp.server.domains.users.partner.Partner;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @NotNull
    private Partner partner;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    private Boolean active;

    public Product() {}

    public Product(@NotNull String name, Float price, String urlImage, Integer daysProduce, Integer quantity, @NotNull Boolean available, @NotNull Category category, @NotNull Partner partner, @NotNull Boolean active){
        this.name = name;
        this.price = price;
        this.urlImage = urlImage;
        this.daysProduce = daysProduce;
        this.quantity = quantity;
        this.available = available;
        this.category = category;
        this.partner = partner;
        this.active = active;
    }

}
