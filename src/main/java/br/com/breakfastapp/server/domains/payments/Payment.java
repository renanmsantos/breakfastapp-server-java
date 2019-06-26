package br.com.breakfastapp.server.domains.payments;

import br.com.breakfastapp.server.domains.orders.Order;
import br.com.breakfastapp.server.domains.payments.enuns.EnumPaymentStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private EnumPaymentStatus paymentStatus;

    @NotNull
    private Order order;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
