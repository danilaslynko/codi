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

    @PutMapping("/create")
    public User create(User item) {
        return service.create(item);
    }

    @GetMapping("/getById")
    public User getById(Integer id) {
        return service.getById(id);
    }

    @PutMapping("/change")
    public User change(User item) {
        return service.change(item);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(Integer id) {
        service.deleteById(id);
    }
}
