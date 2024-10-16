package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name = "course_id", columnNames = "courseId"))
@Entity(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course_description", nullable = false)
    private String description;

    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;

    @Column(name = "course_time", nullable = false)
    private String time;

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "course")
    private List<Task> tasks;
}
