package org.example.mp3_player;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Mp3PlayerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}