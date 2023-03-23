package ru.mtuci.codi.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.codi.entity.task.Task;
import ru.mtuci.codi.entity.task.TaskService;


@RestController
@RequestMapping("/api/task")
@Slf4j
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PutMapping("/create")
    public Task create(Task item) {
        return service.create(item);
    }

    @GetMapping("/getById")
    public Task getById(Integer id) {
        return service.getById(id);
    }

}
