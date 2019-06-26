package br.com.breakfastapp.server.domains.users.customer;

import br.com.breakfastapp.server.domains.users.customer.enuns.EnumInviteStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String guestName;

    @NotNull
    private String guestEmail;

    private EnumInviteStatus inviteStatus;


}
