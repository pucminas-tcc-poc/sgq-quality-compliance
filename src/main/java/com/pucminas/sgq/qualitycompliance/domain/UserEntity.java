package com.pucminas.sgq.qualitycompliance.domain;

import com.pucminas.sgq.qualitycompliance.enums.UserGenre;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "USER")
public class UserEntity extends BaseEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER", nullable = false)
    private Long id;

    @Column(name = "DES_NAME")
    private String name;

    @Column(name = "DES_EMAIL")
    private String email;

    @Column(name = "DES_DOCUMENT")
    private String document;

    @Column(name = "DES_PHONE")
    private String phone;

    @Column(name = "DES_GENRE")
    private UserGenre genre;

    @ManyToMany(mappedBy = "users")
    private Set<ProfileEntity> profiles = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROLE")
    private RoleEntity role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DEPARTAMENT")
    private DepartamentEntity departament;
}
