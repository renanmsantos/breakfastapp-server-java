package br.com.breakfastapp.server.domains.users.partner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
    private String cnpj;

    private Float deliveryFee;

    @NotNull
    private String phone;

    @NotNull
    private Segment segment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
