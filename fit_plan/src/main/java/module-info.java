module org.example.fit_plan {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires jdk.jdi;
    requires java.sql;
    requires org.slf4j;


    opens org.example.fit_plan to javafx.fxml;
    exports org.example.fit_plan;
}