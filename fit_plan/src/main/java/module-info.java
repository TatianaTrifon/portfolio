module org.example.fit_plan {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;



    opens org.example.fit_plan to javafx.fxml;
    exports org.example.fit_plan;
}