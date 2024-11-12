package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.dao.implimentations.WeightDAOImpl;
import org.example.fit_plan.model.UserAccount;
import org.example.fit_plan.model.Weight;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class UserProgressController implements Initializable {

    @FXML
    private ImageView backImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView, exitImage, menuImage, dishImageView;

    @FXML
    private AnchorPane mainPane, buttonsPane, iconPane, toolPane;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;

    @FXML
    private Label nameLabel;

    @FXML
    private ComboBox<String> activityComboBox;

    private final String[] activities = {"Sedentary: little or no exercise",
            "Light: exercise 1-3 times/week",
            "Moderate: exercise 4-5 times/week",
            "Active: daily exercise or intense exercise 3-4 times/week",
            "Very active: intense exercise 6-7 times/week",
            "Extra active: very intense exercise daily, or physical job"};

    @FXML
    private Button saveButton;

    @FXML
    private LineChart<String, Number> weightLineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private XYChart.Series<String, Number> weightSeries = new XYChart.Series<>();

    @FXML
    private TextField heightField, weightField;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private UserAccount userAccount;

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;

        heightField.setText(String.valueOf(userAccount.getHeight()));
        weightField.setText(String.valueOf(userAccount.getWeight()));
        activityComboBox.setValue(userAccount.getActivity());

        loadInitialWeightData();

    }

    @FXML
    public void goToHome(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-account.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToWorkout(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-exercise.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToDiets(){}

    @FXML
    public void goToDish(){}

    @FXML
    public void goToProgress(){}

    @FXML
    public void goToSettings(){}

    @FXML
    public void goToSignIn(){}


    @FXML
    public void saveProgress() {

        WeightDAOImpl weightDAO = new WeightDAOImpl();
        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();

        try {
            double newWeight = Double.parseDouble(weightField.getText());


            Weight newWeightEntry = new Weight(userAccount.getUserId(), newWeight, new Timestamp(System.currentTimeMillis()));
            weightDAO.create(newWeightEntry);

            userAccount.setWeight(newWeight);
            UserAccount updatedUser = userAccountDAO.update(userAccount);

                    String month = new SimpleDateFormat("MMMM").format(newWeightEntry.getEntryDate());
            weightSeries.getData().add(new XYChart.Data<>(month, newWeight));


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void loadInitialWeightData() {

            WeightDAOImpl weightDAO = new WeightDAOImpl();
            List<Weight> weights = weightDAO.findById(userAccount.getUserId());
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");

            weightSeries.getData().clear();

            double minWeight = weights.stream().mapToDouble(Weight::getWeight).min().orElse(0.0);

            for (Weight weight : weights) {
                String month = monthFormat.format(weight.getEntryDate());
                weightSeries.getData().add(new XYChart.Data<>(month, weight.getWeight()));
            }
            
            xAxis.setCategories(FXCollections.observableArrayList(
                    weights.stream()
                            .map(w -> monthFormat.format(w.getEntryDate()))
                            .distinct()
                            .toList()
            ));
            xAxis.setTickLabelRotation(45);

        yAxis.setForceZeroInRange(false);

            yAxis.setAutoRanging(false);
            yAxis.setLowerBound(minWeight - 25);
            yAxis.setUpperBound(weights.stream().mapToDouble(Weight::getWeight).max().orElse(minWeight) + 25);
            yAxis.setTickUnit(5);

            weightSeries.setName("Weight progress");
            weightLineChart.getData().add(weightSeries);
        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image exit = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitImage.setImage(exit);

        Image menu = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\menu.png");
        menuImage.setImage(menu);

        Image home = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\home.png");
        homeView.setImage(home);

        Image diets = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);

        Image workout = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        workoutView.setImage(workout);

        Image dish = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishView.setImage(dish);

        Image progress = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\progress.png");
        progressView.setImage(progress);

        Image settings = new javafx.scene.image.Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\settings.png");
        settingsView.setImage(settings);

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);


        buttonsPane.setTranslateX(-600);


        exitImage.setOnMouseClicked(event -> System.exit(0));

        menuImage.setOnMouseClicked(event -> {
            TranslateTransition paneTransition = new TranslateTransition(Duration.millis(500), buttonsPane);

            if (buttonsPane.getTranslateX() != 0) {
                paneTransition.setToX(0);
            } else {
                paneTransition.setToX(-600);
            }

            paneTransition.play();
        });



    }


}
