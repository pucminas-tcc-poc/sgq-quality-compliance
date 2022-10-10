package com.pucminas.sgq.qualitycompliance.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserProfileId implements Serializable {

    @Column(name = "id_profile")
    private Long profileId;

    @Column(name = "id_user")
    private Long userId;

}
