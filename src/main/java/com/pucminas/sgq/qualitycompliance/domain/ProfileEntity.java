package com.pucminas.sgq.qualitycompliance.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProfileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile", nullable = false)
    private Long id;

    @Column(name = "des_profile")
    private String profile;

    @OneToMany(mappedBy = "profile")
    private List<UserProfileEntity> userProfiles;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "dt_update")
    private LocalDateTime updateDate;
}
