package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.DeliveryStatus;
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
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

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

    public Delivery(@NotNull DeliveryStatus deliveryStatus, @NotNull LocalDateTime scheduledDate, @NotNull Address address){
        this.deliveryStatus = deliveryStatus;
        this.scheduledDate = scheduledDate;
        this.address = address;
    }

}
