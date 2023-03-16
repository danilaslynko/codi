package ru.mtuci.codi.entity.project;

import org.springframework.stereotype.Service;
import ru.mtuci.codi.common.BaseService;

@Service
public class ProjectService extends BaseService<Project> {

    private final ProjectRepo repo;

    public ProjectService(ProjectRepo repo) {
        super(repo);
        this.repo = repo;
    }
}
