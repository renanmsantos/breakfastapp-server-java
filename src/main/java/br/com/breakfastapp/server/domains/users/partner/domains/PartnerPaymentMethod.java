package br.com.breakfastapp.server.domains.users.partner.domains;

import br.com.breakfastapp.server.domains.payments.PaymentMethod;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class PartnerPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @NotNull
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    @NotNull
    private PaymentMethod paymentMethod;

    @Column
    private Integer quotaPermitted;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;

}
