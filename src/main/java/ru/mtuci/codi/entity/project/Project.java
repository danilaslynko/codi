package ru.mtuci.codi.entity.project;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(fluent = true, chain = true)
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

}
