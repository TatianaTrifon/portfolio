package org.example.task_manager.dao;

import org.example.task_manager.entities.Task;

import java.util.List;

public interface TaskDAO extends DAO<Task> {

    Task create(Task task);

    Task update(Task task);

    boolean deleteById(Integer id);

    List<Task> findByCategory(String category);

    List<Task> findByPriority(String priority);

    List<Task> findAll();


}
