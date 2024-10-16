package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name = "task_id", columnNames = "taskId"))
@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_description", nullable = false)
    private String taskDescription;

    @Column(name = "task_deadline", nullable = false, columnDefinition = "DATE")
    private LocalDate deadline;

    @ManyToMany
    @JoinTable(name = "task_group", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
