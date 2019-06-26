package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.EnumOrderStatus;
import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.domains.users.partner.Partner;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private EnumOrderStatus orderStatus;

    @NotNull
    private Customer customer;

    @NotNull
    private Partner partner;

    private Delivery delivery;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;


}
