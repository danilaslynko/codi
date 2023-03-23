package ru.mtuci.codi.entity.pojo;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String login;
    private String password;
}
