package br.com.breakfastapp.server.domains.users.customer.domains;

import br.com.breakfastapp.server.domains.users.customer.enuns.InviteStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
@Data
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String guestName;

    @Column
    @NotNull
    private String guestEmail;

    @Column
    @Enumerated(EnumType.STRING)
    private InviteStatus inviteStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer invitedByCustomer;

    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    @NotNull
    private CustomerGroup invitedToCustomerGroup;

    @Column(updatable = false)
    @CreationTimestamp
    private Calendar createdAt;

    @Column
    @UpdateTimestamp
    private Calendar updatedAt;

}
