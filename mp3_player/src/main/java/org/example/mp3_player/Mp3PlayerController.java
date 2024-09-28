package org.example.mp3_player;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Mp3PlayerController implements Initializable {
    @FXML
    private Label musicNameLabel;

    @FXML
    private ProgressBar musicProgressBar;

    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;

    @FXML
    private ComboBox<String> speedBox;

    @FXML
    private Slider volumeSlider;

    private File directory;

    private File[] files; //just for using the listFiles() method

    private ArrayList<File> playList;

    private int songNumber;

    private double[] speeds = {0.25, 0.50, 0.75, 1, 1.25, 1.50, 1.75, 2};

    private Timer timer;

    private TimerTask task;

    public static boolean running;

    private Media media;

    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playList = new ArrayList<File>();

        directory = new File("src/music");

        files = directory.listFiles(); // it will store all the files within the directory (music file)

        if (files != null) {
            for (File file : files) {
                playList.add(file);
                System.out.println(file);
            }
        }

        media = new Media(playList.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        musicNameLabel.setText(playList.get(songNumber).getName());

        for (int i = 0; i < speeds.length; i++) {
            speedBox.getItems().add(Double.toString(speeds[i]));

        }
        speedBox.setOnAction(this::changeMusicSpeed);


        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });


    }

    @FXML
    public void playMusic() {

        beginTimer();
        changeMusicSpeed(null);
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
        mediaPlayer.play();
    }

    @FXML
    public void pauseMusic() {
        stopTimer();
        mediaPlayer.pause();
    }

    @FXML
    public void resetMusic() {
        musicProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0));
    }

    @FXML
    public void setToPrevious() {
        if (songNumber > 0) {

            songNumber--;

            mediaPlayer.stop();

            if (running) {
                stopTimer();
            }

            media = new Media(playList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            musicNameLabel.setText(playList.get(songNumber).getName());

            playMusic();

        } else {
            songNumber = playList.size() - 1;

            mediaPlayer.stop();
            if (running) {
                stopTimer();
            }

            media = new Media(playList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            musicNameLabel.setText(playList.get(songNumber).getName());

            playMusic();
        }
    }

    @FXML
    public void setToNext() {

        if (songNumber < playList.size() - 1) {

            songNumber++;

            mediaPlayer.stop();

            if (running) {
                stopTimer();
            }

            media = new Media(playList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            musicNameLabel.setText(playList.get(songNumber).getName());

            playMusic();

        } else {
            songNumber = 0;

            mediaPlayer.stop();
            if (running) {
                stopTimer();
            }
            media = new Media(playList.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            musicNameLabel.setText(playList.get(songNumber).getName());

            playMusic();
        }
    }

    @FXML
    public void changeMusicSpeed(ActionEvent event) {
        if (speedBox.getValue() == null) {
            mediaPlayer.setRate(1);
        } else {
            mediaPlayer.setRate(Double.parseDouble(speedBox.getValue()));
        }

    }

    public void beginTimer() {
        timer = new Timer();

        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                musicProgressBar.setProgress(current / end);

                if (current / end == 1) {
                    stopTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 10);
    }

    public void stopTimer() {
        running = false;
        timer.cancel();
    }
}