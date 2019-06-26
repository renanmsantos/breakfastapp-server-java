package br.com.breakfastapp.server.domains.users.partner;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @NaturalId
    private String cnpj;

    private Float deliveryFee;

    @NotNull
    private String phone;

    @NotNull
    private Segment segment;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
