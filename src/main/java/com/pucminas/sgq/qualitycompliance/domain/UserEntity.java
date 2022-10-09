package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.UserGenre;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_email")
    private String email;

    @Column(name = "des_document")
    private String document;

    @Column(name = "des_phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_genre")
    private UserGenre genre;

    @ManyToMany(mappedBy = "users")
    private Set<ProfileEntity> profiles = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private RoleEntity role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departament")
    private DepartamentEntity departament;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}
