package br.com.breakfastapp.server.domains.orders;

import br.com.breakfastapp.server.domains.users.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    @NotNull
    private String comments;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
