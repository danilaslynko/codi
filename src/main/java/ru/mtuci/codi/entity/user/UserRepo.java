package ru.mtuci.codi.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
