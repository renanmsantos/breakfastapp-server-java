package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.EnumDeliveryStatus;
import br.com.breakfastapp.server.domains.products.Category;
import br.com.breakfastapp.server.domains.users.Address;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private EnumDeliveryStatus deliveryStatus;

    @NotNull
    private LocalDateTime scheduledDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
