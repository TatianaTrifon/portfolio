package org.example.task_manager.controllers;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.task_manager.dao.implementations.TaskDAOImpl;
import org.example.task_manager.entities.Task;
import org.example.task_manager.entities.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TaskManagerController implements Initializable {

    @FXML
    private ListView<Task> taskListView;

    @FXML
    private Button createTaskButton;

    @FXML
    private ComboBox<String> priorityBox;

    String[] priorities = {"High", "Medium", "Low"};

    @FXML
    private ComboBox<String> categoryBox;


    String[] categories = {"Education", "Work", "Hobby", "Sport", "Chores", "Finance"};

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;



    private User user = new User();


    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    public void changeToCreateTask() throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task.fxml"));

        stage = new Stage();

        scene = new Scene(root.load());
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);


        stage.setOnCloseRequest(event -> {
            closeEditWindow(stage);
            closeEditWindow(stage);
        });


        TaskController controller = root.getController();
        controller.setUserId(user.getId());
        controller.getDoneButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.editTask();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                closeEditWindow(stage);
                closeEditWindow(stage);
            }
        });
        controller.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.deleteTask();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                closeEditWindow(stage);
                closeEditWindow(stage);
            }
        });


        stage.show();


    }

    @FXML
    public void changeToEditTask(Task task) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/task_manager/task.fxml"));

        stage = new Stage();
        scene = new Scene(root.load());

        TaskController controller = root.getController();
        controller.setTask(task);
        controller.setUserId(user.getId());

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);


        stage.setOnCloseRequest(event -> {
            closeEditWindow(stage);
            closeEditWindow(stage);
        });

        controller.getDoneButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.editTask();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                closeEditWindow(stage);
                closeEditWindow(stage);
            }
        });

        controller.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.deleteTask();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                closeEditWindow(stage);
                closeEditWindow(stage);
            }
        });


        stage.show();

    }



    @FXML
    public void choosePriority(ActionEvent event) {
        TaskDAOImpl taskDAOImpl = new TaskDAOImpl();

        taskListView.getItems().clear();
        taskListView.getItems().addAll(taskDAOImpl.findByPriority(priorityBox.getValue()));


    }

    @FXML
    public void chooseCategory(ActionEvent event) {
        TaskDAOImpl taskDAOImpl = new TaskDAOImpl();
        taskListView.getItems().clear();
        taskListView.getItems().addAll(taskDAOImpl.findByCategory(categoryBox.getValue()));


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TaskDAOImpl taskDAOImpl = new TaskDAOImpl();
        taskListView.getItems().clear();
        taskListView.getItems().addAll(taskDAOImpl.findAll());


        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
            @Override
            public void changed(ObservableValue<? extends Task> observableValue, Task task, Task t1) {

                Task currentTask = taskListView.getSelectionModel().getSelectedItem();


                try {
                    changeToEditTask(currentTask);


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }


        });

        for (int i = 0; i < priorities.length; i++) {
            priorityBox.getItems().add(priorities[i]);

        }

        priorityBox.setOnAction(this::choosePriority);


        for (int i = 0; i < categories.length; i++) {
            categoryBox.getItems().add(categories[i]);

        }

        categoryBox.setOnAction(this::chooseCategory);

    }

    public void closeEditWindow(Stage stage) {
        stage.close();
        refreshListView();
        clearTaskSelection();


    }

    public void clearTaskSelection() {
        taskListView.getSelectionModel().clearSelection();

    }

    @FXML
    public void goToSettings(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/task_manager/account.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root.load());
        AccountController controller = root.getController();
        controller.setUser(user);
        stage.setScene(scene);




        stage.show();
    }

    public void refreshListView(){
        TaskDAOImpl taskDAOImpl = new TaskDAOImpl();
        taskListView.getItems().clear();
        taskListView.getItems().addAll(taskDAOImpl.findAll());

    }


}
