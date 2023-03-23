package ru.mtuci.codi.entity.user;


import lombok.Data;
import ru.mtuci.codi.entity.role.Role;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private Role role;

    @Column(name = "create_date")
    private Date createDate;
}
