module org.example.task_manager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.task_manager to javafx.fxml;
    exports org.example.task_manager;
}