module org.example.fit_plan {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.fit_plan to javafx.fxml;
    exports org.example.fit_plan;
}