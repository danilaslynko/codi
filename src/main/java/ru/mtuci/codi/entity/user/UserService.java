package ru.mtuci.codi.entity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mtuci.codi.entity.role.Role;
import ru.mtuci.codi.entity.role.RoleRepo;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public User create(User user) {
        Role userRole = roleRepo.findByRole("ROLE_USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(new Date());
        return userRepo.save(user);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = userRepo.findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public User findByLogin(String login){
        return userRepo.findByLogin(login);
    }

    public User getById(Integer id) {
        return userRepo.getById(id);
    }

}
