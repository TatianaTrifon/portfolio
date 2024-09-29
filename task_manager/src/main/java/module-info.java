module org.example.task_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.slf4j;


    opens org.example.task_manager to javafx.fxml;
    exports org.example.task_manager;
    exports org.example.task_manager.controllers;
    opens org.example.task_manager.controllers to javafx.fxml;
}