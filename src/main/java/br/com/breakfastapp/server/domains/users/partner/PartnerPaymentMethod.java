package br.com.breakfastapp.server.domains.users.partner;

import br.com.breakfastapp.server.domains.payments.PaymentMethod;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class PartnerPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @NotNull
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    @NotNull
    private PaymentMethod paymentMethod;

    private Integer quotaPermitted;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public PartnerPaymentMethod(@NotNull Partner partner, @NotNull PaymentMethod paymentMethod, Integer quotaPermitted) {
        this.partner = partner;
        this.paymentMethod = paymentMethod;
        this.quotaPermitted = quotaPermitted;
    }
}
