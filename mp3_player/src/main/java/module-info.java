module org.example.mp3_player {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;


    opens org.example.mp3_player to javafx.fxml;
    exports org.example.mp3_player;
}