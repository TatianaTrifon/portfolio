module org.example.mp3_player {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mp3_player to javafx.fxml;
    exports org.example.mp3_player;
}