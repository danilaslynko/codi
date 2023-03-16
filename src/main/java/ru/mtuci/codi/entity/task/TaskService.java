package ru.mtuci.codi.entity.task;

import org.springframework.stereotype.Service;
import ru.mtuci.codi.common.BaseService;

@Service
public class TaskService extends BaseService<Task> {
    private final TaskRepo repo;

    public TaskService(TaskRepo repo) {
        super(repo);
        this.repo = repo;
    }
}
