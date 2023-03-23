package ru.mtuci.codi.entity.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo repo;

    public Project create(Project project) {
        return repo.save(project);
    }

    public Project getById(Integer id) {
        return repo.getById(id);
    }


}
