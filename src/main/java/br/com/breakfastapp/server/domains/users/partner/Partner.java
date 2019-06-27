package br.com.breakfastapp.server.domains.users.partner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    @JsonIgnore
    private String password;

    @Column
    @NotNull
    @NaturalId
    private String cnpj;

    @Column
    private Float deliveryFee;

    @Column
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

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column
    @UpdateTimestamp
    private Date updatedAt;

    @Column
    @NotNull
    private Boolean active;

}
