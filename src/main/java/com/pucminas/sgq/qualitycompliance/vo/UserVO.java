package com.pucminas.sgq.qualitycompliance.vo;

import com.pucminas.sgq.qualitycompliance.enums.UserGenre;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserVO {
    String name;
    String email;
    String phone;
    String document;
    UserGenre genre;
    RoleVO role;
    DepartamentVO departament;
}
