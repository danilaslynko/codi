package ru.mtuci.codi.entity.pojo;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
