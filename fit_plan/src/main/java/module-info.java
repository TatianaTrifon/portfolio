module org.example.fit_plan {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;
    requires org.slf4j;
    requires static lombok;


    opens org.example.fit_plan.controllers to javafx.fxml;

    opens org.example.fit_plan to javafx.fxml;
    exports org.example.fit_plan;
}
