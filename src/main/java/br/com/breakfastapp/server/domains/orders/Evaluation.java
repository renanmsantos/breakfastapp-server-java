package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.users.customer.Customer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Customer customer;

    @NotNull
    private Order order;

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

}
