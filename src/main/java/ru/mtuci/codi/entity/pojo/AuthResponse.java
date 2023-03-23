package ru.mtuci.codi.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mtuci.codi.entity.role.Role;

import java.util.Date;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String login;
    private String firstName;
    private String lastName;
    private Role role;
    private Date createDate;
}
