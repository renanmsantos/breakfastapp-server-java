package br.com.breakfastapp.server.domains.users.partner;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class SocialInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String url;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @NotNull
    private Partner partner;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    private Boolean active;

    public SocialInformation(@NotNull String name, String description, @NotNull String url, @NotNull Partner partner, @NotNull Boolean active) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.partner = partner;
        this.active = active;
    }
}
