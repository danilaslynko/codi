package ru.mtuci.codi.entity.user;

import org.springframework.stereotype.Service;
import ru.mtuci.codi.common.BaseService;

@Service
public class UserService extends BaseService<User> {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        super(repo);
        this.repo = repo;
    }
}
