package br.com.breakfastapp.server.domains.users.customer;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
@Data
public class CustomerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @Column(updatable = false)
    @CreationTimestamp
    private Calendar createdAt;

    @Column
    @UpdateTimestamp
    private Calendar updatedAt;

    @Column
    @NotNull
    private Boolean active;

}
