package ru.mtuci.codi.entity.task;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Accessors(fluent = true, chain = true)
@Entity
@Table(name = "task")
public class TaskStatusHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "author")
    private String author;

    @Column(name = "task_status_from")
    private String taskStatusFrom;

    @Column(name = "task_status_to")
    private String taskStatusTo;

    @Column(name = "change_date")
    private Date changeDate;
}
