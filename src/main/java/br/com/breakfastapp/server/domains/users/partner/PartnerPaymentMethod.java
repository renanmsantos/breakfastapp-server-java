package br.com.breakfastapp.server.domains.users.partner;

import br.com.breakfastapp.server.domains.payments.PaymentMethod;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
