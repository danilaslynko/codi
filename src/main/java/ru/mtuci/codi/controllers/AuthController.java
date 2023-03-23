package ru.mtuci.codi.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.mtuci.codi.conf.jwt.JwtProvider;
import ru.mtuci.codi.entity.pojo.AuthRequest;
import ru.mtuci.codi.entity.pojo.AuthResponse;
import ru.mtuci.codi.entity.pojo.RegistrationRequest;
import ru.mtuci.codi.entity.user.User;
import ru.mtuci.codi.entity.user.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log
@RestController
public class AuthController {
    public static final String AUTHORIZATION = "Authorization";
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.OK)
    public void registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User u = new User();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.create(u);
        log.info("User " + u.getLogin() + " was created.");
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request, HttpServletResponse response) {
        User userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        Cookie cookie = new Cookie(AUTHORIZATION, token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        AuthResponse authResponse = new AuthResponse(userEntity.getLogin(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getRole(), userEntity.getCreateDate());
        return authResponse;
    }
}
