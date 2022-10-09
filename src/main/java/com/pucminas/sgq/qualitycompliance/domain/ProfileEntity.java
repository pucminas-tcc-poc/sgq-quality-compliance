package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "PROFILE")
public class ProfileEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PROFILE", nullable = false)
    private Long id;

    @Column(name = "DES_PROFILE")
    private String profile;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "USER_PROFILE",
            joinColumns = @JoinColumn(name = "ID_PROFILE"),
            inverseJoinColumns = @JoinColumn(name = "ID_USER")
    )
    private Set<UserEntity> users = new HashSet<>();
}
