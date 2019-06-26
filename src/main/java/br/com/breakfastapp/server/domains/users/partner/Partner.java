package br.com.breakfastapp.server.domains.users.partner;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "segment_id")
    @NotNull
    private Segment segment;

    @OneToMany
    private List<SocialInformation> socialInformation = new ArrayList<>();

    @OneToMany
    private List<PartnerPaymentMethod> partnerPaymentMethods = new ArrayList<>();

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    private Boolean active;

    public Partner(Integer id, String name, @NotNull String email, @NotNull String password, @NotNull String cnpj, Float deliveryFee, @NotNull String phone, @NotNull Segment segment, @NotNull Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cnpj = cnpj;
        this.deliveryFee = deliveryFee;
        this.phone = phone;
        this.segment = segment;
        this.active = active;
    }
}
