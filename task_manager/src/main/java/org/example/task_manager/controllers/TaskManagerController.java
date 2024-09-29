package org.example.task_manager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class TaskManagerController {

    @FXML
    private ListView<String> taskListView;

    @FXML
    private Button createTaskButton;

    @FXML
    private ComboBox priorityBox;

    @FXML
    private ComboBox categoryBox;

    @FXML
    public void changeToCreateTask(){}

    @FXML
    public void choosePriority(){}

    @FXML
    public void chooseCategory(){}
}
