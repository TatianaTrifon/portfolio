package org.example.task_manager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.task_manager.dao.implementations.TaskDAOImpl;
import org.example.task_manager.entities.Task;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TaskController implements Initializable {

    @FXML
    private TextField taskName;

    @FXML
    private TextField taskDescription;

    @FXML
    private ComboBox<String> taskPriorityBox;

    @FXML
    private ComboBox<String> taskCategoryBox;

    @FXML
    private DatePicker taskDeadlinePicker;

    @FXML
    private Button doneButton;

    private FXMLLoader root;

    private AnchorPane pane;

    private Stage stage;

    private int userId;

    private Scene scene;

    String[] priorities = {"High", "Medium", "Low"};

    String[] categories = {"Education", "Work", "Hobby", "Sport", "Chores", "Finance"};



    private Task task = new Task();

    public void setTask(Task task) {
        this.task = task;

        if (this.task != null) {
            taskName.setText(task.getName());
            taskDescription.setText(task.getDescription());
            taskPriorityBox.setValue(task.getPriority());
            taskCategoryBox.setValue(task.getCategory());
            taskDeadlinePicker.setValue(task.getDeadline());
        }
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @FXML
    public void editTask() {

        TaskDAOImpl taskDAOImpl = new TaskDAOImpl();
        if (task != null) {


            Task updatedTask = taskDAOImpl.update(new Task(task.getId(),taskName.getText(), taskDescription.getText(), taskPriorityBox.getValue(), taskCategoryBox.getValue(), taskDeadlinePicker.getValue(), userId));

            if (updatedTask != null) {
                stage = (Stage) doneButton.getScene().getWindow();
                stage.close();
            }

        } else {
            String name = taskName.getText();
            String desription = taskDescription.getText();
            String priority = taskPriorityBox.getValue();
            String category = taskCategoryBox.getValue();
            LocalDate deadline = taskDeadlinePicker.getValue();

            Task newTask = taskDAOImpl.create(new Task(name, desription, priority, category, deadline, userId));

            if (newTask != null) {

                stage = (Stage) doneButton.getScene().getWindow();
                stage.close();

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Failed to create a task");
            }


        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task.fxml"));



        for (int i = 0; i < priorities.length; i++) {
            taskPriorityBox.getItems().add(priorities[i]);

        }


        for (int i = 0; i < categories.length; i++) {
            taskCategoryBox.getItems().add(categories[i]);

        }




    }

}
