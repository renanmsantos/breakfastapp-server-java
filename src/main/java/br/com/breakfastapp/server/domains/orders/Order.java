package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.EnumOrderStatus;
import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.domains.users.partner.Partner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private EnumOrderStatus status;
    private Customer customer;
    private Partner partner;
    private Delivery delivery;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
