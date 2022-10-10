package com.pucminas.sgq.qualitycompliance.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_profile")
public class UserProfileEntity implements Serializable {

    @EmbeddedId
    private UserProfileId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @ManyToOne
    @MapsId("profileId")
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;

}
