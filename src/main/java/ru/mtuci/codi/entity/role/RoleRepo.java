package ru.mtuci.codi.entity.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
