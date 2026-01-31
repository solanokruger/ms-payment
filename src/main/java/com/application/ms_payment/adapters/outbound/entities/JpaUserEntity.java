package com.application.ms_payment.adapters.outbound.entities;

import com.application.ms_payment.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class JpaUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DOCUMENT")
    private String document;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<JpaUserRoleEntity> roles = new ArrayList<>();

    @OneToOne
    private JpaUserWalletEntity wallet;

    public JpaUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.document = user.getDocument();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
