package br.com.breakfastapp.server.domains.users.customer;

import br.com.breakfastapp.server.domains.users.customer.enuns.InviteStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String guestName;

    @NotNull
    private String guestEmail;

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

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Invite(@NotNull String guestName, @NotNull String guestEmail, InviteStatus inviteStatus, @NotNull Customer invitedByCustomer, @NotNull CustomerGroup invitedToCustomerGroup) {
        this.guestName = guestName;
        this.guestEmail = guestEmail;
        this.inviteStatus = inviteStatus;
        this.invitedByCustomer = invitedByCustomer;
        this.invitedToCustomerGroup = invitedToCustomerGroup;
    }
}
