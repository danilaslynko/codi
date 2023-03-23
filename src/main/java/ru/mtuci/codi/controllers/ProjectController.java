package ru.mtuci.codi.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.codi.entity.project.Project;
import ru.mtuci.codi.entity.project.ProjectService;

@RestController
@RequestMapping("/api/project")
@Slf4j
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;

    @PutMapping("/create")
    public Project create(Project item) {
        return service.create(item);
    }

    @GetMapping("/getById")
    public Project getById(Integer id) {
        return service.getById(id);
    }
}
