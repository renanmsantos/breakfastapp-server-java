package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.orders.enuns.PurchaseOrderStatus;
import br.com.breakfastapp.server.domains.users.customer.Customer;
import br.com.breakfastapp.server.domains.users.partner.Partner;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus purchaseOrderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @NotNull
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public PurchaseOrder(@NotNull PurchaseOrderStatus purchaseOrderStatus, @NotNull Customer customer, @NotNull Partner partner, Delivery delivery){
        this.purchaseOrderStatus = purchaseOrderStatus;
        this.customer = customer;
        this.partner = partner;
        this.delivery = delivery;
    }

}
