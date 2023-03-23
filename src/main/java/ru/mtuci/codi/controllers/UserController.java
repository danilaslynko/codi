package ru.mtuci.codi.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.codi.entity.user.User;
import ru.mtuci.codi.entity.user.UserService;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/getById")
    public User getById(Integer id) {
        return service.getById(id);
    }

}
