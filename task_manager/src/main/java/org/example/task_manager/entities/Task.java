package org.example.task_manager.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private int id;

    private String name;

    private String description;

    private String priority;

    private String category;

    private LocalDate deadline;

    private int userId;

    public Task() {
    }

    public Task(int id, String name, String description, String priority, String category, LocalDate deadline, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.deadline = deadline;
        this.userId = userId;
    }

    public Task(String name, String description, String priority, String category, LocalDate deadline, int userId) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.deadline = deadline;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && userId == task.userId && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(priority, task.priority) && Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, priority, category, userId);
    }

    @Override
    public String toString() {
        return name;
    }
}
