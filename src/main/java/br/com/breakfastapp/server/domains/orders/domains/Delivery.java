package br.com.breakfastapp.server.domains.orders.domains;

import br.com.breakfastapp.server.domains.orders.enuns.DeliveryStatus;
import br.com.breakfastapp.server.domains.users.address.domains.Address;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column
    private LocalDateTime scheduledDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;

}
