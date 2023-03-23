package ru.mtuci.codi.entity.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo repo;

    public Task create(Task task) {
        return repo.save(task);
    }

    public Task getById(Integer id) {
        return repo.getById(id);
    }


}
