package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.EnumDeliveryStatus;
import br.com.breakfastapp.server.domains.users.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private EnumDeliveryStatus deliveryStatus;

    @NotNull
    private LocalDateTime scheduledDate;

    @NotNull
    private Address address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
