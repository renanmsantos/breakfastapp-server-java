package br.com.breakfastapp.server.domains.users.partner;

import br.com.breakfastapp.server.domains.payments.PaymentMethod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class PartnerPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Partner partner;

    @NotNull
    private PaymentMethod paymentMethod;

    private Integer quotaPermitted;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
