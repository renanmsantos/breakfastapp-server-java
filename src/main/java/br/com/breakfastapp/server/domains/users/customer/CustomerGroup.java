package br.com.breakfastapp.server.domains.users.customer;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class CustomerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    private String description;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @NotNull
    private Boolean active;

    public CustomerGroup(@NotNull String name, String description, @NotNull Boolean active) {
        this.name = name;
        this.description = description;
        this.active = active;
    }
}
