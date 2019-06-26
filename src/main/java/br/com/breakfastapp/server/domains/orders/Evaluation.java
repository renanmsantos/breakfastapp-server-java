package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.users.customer.Customer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "purchase_order_id")
    @NotNull
    private PurchaseOrder purchaseOrder;

    @NotNull
    private Integer gradeService;

    @NotNull
    private Integer gradeDelivery;

    @NotNull
    private Integer gradeProduct;

    private String comments;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Evaluation() {}

    public Evaluation(@NotNull Customer customer, @NotNull PurchaseOrder purchaseOrder, @NotNull Integer gradeService, @NotNull Integer gradeDelivery, @NotNull Integer gradeProduct, String comments){
        this.customer = customer;
        this.purchaseOrder = purchaseOrder;
        this.gradeService = gradeService;
        this.gradeDelivery = gradeDelivery;
        this.gradeProduct = gradeProduct;
        this.comments = comments;
    }

}
