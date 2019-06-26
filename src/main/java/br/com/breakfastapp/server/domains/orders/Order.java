package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.EnumOrderStatus;
import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.domains.users.partner.Partner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
