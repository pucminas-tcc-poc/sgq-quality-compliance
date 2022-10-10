package com.pucminas.sgq.qualitycompliance.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pucminas.sgq.qualitycompliance.enums.UserGenre;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserEntity implements Serializable {
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

    @OneToMany(mappedBy = "user")
    private List<UserProfileEntity> userProfiles;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private RoleEntity role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departament")
    private DepartamentEntity departament;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}
