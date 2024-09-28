package org.example.mp3_player;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mp3Player.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = this.getClass().getResource("mp3PlayerStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("MP3 Player");
        stage.setResizable(false);

        Image icon = new Image(getClass().getResource("/icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}