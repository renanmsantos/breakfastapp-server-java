package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.users.customer.domains.Customer;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "purchase_order_id")
    @NotNull
    private PurchaseOrder purchaseOrder;

    @Column
    @NotNull
    private Integer gradeService;

    @Column
    @NotNull
    private Integer gradeDelivery;

    @Column
    @NotNull
    private Integer gradeProduct;

    @Column
    private String comments;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;

}
