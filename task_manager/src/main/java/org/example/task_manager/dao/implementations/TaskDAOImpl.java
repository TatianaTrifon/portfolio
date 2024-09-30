package org.example.task_manager.dao.implementations;

import org.example.task_manager.JdbcConnection;
import org.example.task_manager.dao.TaskDAO;
import org.example.task_manager.entities.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskDAOImpl.class);

    JdbcConnection jdbcConnection = new JdbcConnection();

    @Override
    public Task create(Task task) {

        String sql = "INSERT INTO task(task_name, task_description, priority , category, deadline, user_id) VALUES (?,?,?,?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createTask = conn.prepareCall(sql)) {

            createTask.setString(1, task.getName());
            createTask.setString(2, task.getDescription());
            createTask.setString(3, task.getPriority());
            createTask.setString(4, task.getCategory());
            createTask.setDate(5, Date.valueOf(task.getDeadline()));
            createTask.setInt(6, task.getUserId());

            createTask.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to create the task " + e);
        }

        return task;
    }

    @Override
    public Task update(Task task) {

        String sql = "UPDATE task SET task_name = ?, task_description = ?, priority = ?, category = ?, deadline = ? WHERE task_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateTask = conn.prepareCall(sql)) {

            updateTask.setString(1, task.getName());
            updateTask.setString(2, task.getDescription());
            updateTask.setString(3, task.getPriority());
            updateTask.setString(4, task.getCategory());
            updateTask.setDate(5, Date.valueOf(task.getDeadline()));
            updateTask.setInt(6, task.getId());

            updateTask.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update the task with id: " + task.getId() + e);
        }

        return task;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM task WHERE task_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteTask = conn.prepareCall(sql)) {

            deleteTask.setInt(1, id);

            deleteTask.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete the task with id: " + id + e);
        }

        return true;
    }

    @Override
    public List<Task> findByCategory(String category) {

        List<Task> tasks = new ArrayList<>();
        Task task;

        String sql = "SELECT * FROM task WHERE category = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findTasks = conn.prepareCall(sql)) {

            findTasks.setString(1, category);

            ResultSet resultSet = findTasks.executeQuery();

            while (resultSet.next()) {

                Integer id = resultSet.getInt("task_id");
                String name = resultSet.getString("task_name");
                String description = resultSet.getString("task_description");
                String priority = resultSet.getString("priority");
                String taskCategory = resultSet.getString("category");
                LocalDate deadline = resultSet.getDate("deadline").toLocalDate();
                Integer user_id = resultSet.getInt("user_id");

                task = new Task(id, name, description, priority, taskCategory, deadline, user_id);
                tasks.add(task);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any tasks with category : " + category + e);
        }


        return tasks;
    }

    @Override
    public List<Task> findByPriority(String priority) {

        List<Task> tasks = new ArrayList<>();
        Task task;

        String sql = "SELECT * FROM task WHERE priority = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findTasks = conn.prepareCall(sql)) {

            findTasks.setString(1, priority);

            ResultSet resultSet = findTasks.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("task_id");
                String name = resultSet.getString("task_name");
                String description = resultSet.getString("task_description");
                String taskPriority = resultSet.getString("priority");
                String category = resultSet.getString("category");
                LocalDate deadline = resultSet.getDate("deadline").toLocalDate();
                Integer userId = resultSet.getInt("user_id");

                task = new Task(id, name, description, taskPriority, category, deadline, userId);
                tasks.add(task);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any task with priority: " + priority + e);
        }

        return tasks;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        Task task;

        String sql = "SELECT * FROM task";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findTasks = conn.prepareCall(sql)) {



            ResultSet resultSet = findTasks.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("task_id");
                String name = resultSet.getString("task_name");
                String description = resultSet.getString("task_description");
                String taskPriority = resultSet.getString("priority");
                String category = resultSet.getString("category");
                LocalDate deadline = resultSet.getDate("deadline").toLocalDate();
                Integer userId = resultSet.getInt("user_id");

                task = new Task(id, name, description, taskPriority, category, deadline, userId);
                tasks.add(task);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any task with priority: " + e);
        }

        return tasks;
    }
}
