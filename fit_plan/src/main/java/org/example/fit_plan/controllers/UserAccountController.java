package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.dao.implimentations.UserDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.User;
import org.example.fit_plan.model.UserAccount;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class UserAccountController implements Initializable {


    @FXML
    private ImageView exitImage, menuImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView;

    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane, caloriesResultPane;

    @FXML
    private TextField ageField, heightField, weightField;

    @FXML
    private RadioButton maleRadioButton, femaleRadioButton;

    @FXML
    private ComboBox<String> activityComboBox;

    private final String[] activities = {"Sedentary: little or no exercise",
            "Light: exercise 1-3 times/week",
            "Moderate: exercise 4-5 times/week",
            "Active: daily exercise or intense exercise 3-4 times/week",
            "Very active: intense exercise 6-7 times/week",
            "Extra active: very intense exercise daily, or physical job"};

    @FXML
    private Button calculateButton;

    @FXML
    ScrollPane pageScrollPane;

    @FXML
    private Label welcomeLabel, maintainWeightLabel, loseWeightLabel, putWeightLabel, maintainWeight, loseWeight, putOnWeight, recommendedDietsLabel;

    @FXML
    private VBox scrollContent;

    @FXML
    private HBox dietContainer;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;




    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private int userId;
    private String username;

    public void setUserId(int userId) {
        this.userId = userId;

    }

    public void setUsername(String username) {
        this.username = username;
        welcomeLabel.setText("Welcome, " + username + "!");
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

        UserExerciseController controller = root.getController();
        controller.setUserId(userId);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToDiets(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-diet.fxml"));


        scene = new Scene(root.load());

        UserDietController controller = root.getController();
        controller.setUserId(userId);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToDish(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-dish.fxml"));


        scene = new Scene(root.load());

        UserDishController controller = root.getController();
        controller.setUserId(userId);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToProgress(ActionEvent event) throws IOException {

        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-progress.fxml"));


        scene = new Scene(root.load());

        UserProgressController controller = root.getController();

        UserAccount userAccount = userAccountDAO.findById(userId);
        controller.setUserAccount(userAccount);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToSettings(ActionEvent event) throws IOException {
        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-settings.fxml"));


        scene = new Scene(root.load());

        UserProgressController controller = root.getController();

        UserAccount userAccount = userAccountDAO.findById(userId);
        controller.setUserAccount(userAccount);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToSignIn(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/sign-in.fxml"));
        scene = new Scene(root.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pageScrollPane.setFitToWidth(true);
        pageScrollPane.setFitToHeight(true);


        Image exit = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\exit.png");
        exitImage.setImage(exit);

        Image menu = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\menu.png");
        menuImage.setImage(menu);

        Image home = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\home.png");
        homeView.setImage(home);
        homeView.setOnMouseClicked(event -> {
            try {
                goToHome(new ActionEvent(homeView, homeView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image diets = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);
        dietsView.setOnMouseClicked(event -> {
            try {
                goToDiets(new ActionEvent(dietsView, dietsView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image workout = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        workoutView.setImage(workout);
        workoutView.setOnMouseClicked(event -> {
            try {
                goToWorkout(new ActionEvent(workoutView, workoutView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image dish = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishView.setImage(dish);
        dishView.setOnMouseClicked(event -> {
            try {
                goToDish(new ActionEvent(dish, dishView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image progress = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\progress.png");
        progressView.setImage(progress);
        progressView.setOnMouseClicked(event -> {
            try {
                goToProgress(new ActionEvent(progressView, progressView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image settings = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\settings.png");
        settingsView.setImage(settings);
        settingsView.setOnMouseClicked(event -> {
            try {
                goToSettings(new ActionEvent(settingsView, settingsView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Image logOut = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\logOut.png");
        logOutView.setImage(logOut);
        logOutView.setOnMouseClicked(event -> {
            try {
                goToSignIn(new ActionEvent(logOutView, logOutView.getScene().getWindow()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


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


        for (int i = 0; i < activities.length; i++) {
            activityComboBox.getItems().add(activities[i]);
        }

        caloriesResultPane.getChildren().clear();

    }

    @FXML
    public void calculateCalories() {

            dietContainer.getChildren().clear();
        caloriesResultPane.getChildren().clear();


        double bmr;


        UserAccountDAOImpl userAccountDAOImpl = new UserAccountDAOImpl();

        int age = Integer.parseInt(ageField.getText());
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
        double height = Double.parseDouble(heightField.getText());
        double weight = Double.parseDouble(weightField.getText());
        String activity = activityComboBox.getValue();

        UserAccount existingAccount = userAccountDAOImpl.findById(userId);

        if(existingAccount.getUserId() == 0) {
           UserAccount userAccount = new UserAccount(userId, age, gender, height, weight, activity);
            userAccountDAOImpl.create(userAccount);
        }

        if (gender.equalsIgnoreCase("Male")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        double activityFactor = getActivityFactor(activity);

        double maintainWeightValue = bmr * activityFactor;
        double loseWeightValue = maintainWeightValue * 0.85;
        double putWeightValue = maintainWeightValue * 1.15;

        maintainWeightLabel.setText(String.format("%.2f", maintainWeightValue) + " kcal");
        loseWeightLabel.setText(String.format("%.2f", loseWeightValue) + " kcal");
        putWeightLabel.setText(String.format("%.2f", putWeightValue) + " kcal");

        caloriesResultPane.getChildren().addAll(maintainWeightLabel, loseWeightLabel, putWeightLabel, maintainWeight, loseWeight, putOnWeight,recommendedDietsLabel);

        showRecommendedDiets();

    }

    public double getActivityFactor(String activityLevel) {
        return switch (activityLevel) {
            case "Sedentary: little or no exercise" -> 1.2;
            case "Light: exercise 1-3 times/week" -> 1.375;
            case "Moderate: exercise 4-5 times/week" -> 1.55;
            case "Active: daily exercise or intense exercise 3-4 times/week" -> 1.725;
            case "Very active: intense exercise 6-7 times/week" -> 1.9;
            case "Extra active: very intense exercise daily, or physical job" -> 2.0;
            default -> 1.0;
        };
    }

    public void goToDietDetails(Diet diet){

        try {
            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/diet-details.fxml"));

            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            Stage dietDetailsStage = new Stage();
            dietDetailsStage.setScene(new Scene(root.load()));

            DietDetailsController controller = root.getController();
            controller.setDiet(diet);
            controller.setUserId(userId);
            controller.setPreviousStage(currentStage);

            currentStage.hide();
            dietDetailsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showRecommendedDiets() {


        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        List<Diet> diets = dietDAOImpl.findRecommendedDiets();

        dietContainer.setSpacing(20);


        for (Diet diet : diets) {
            VBox dietBox = new VBox(10);
            dietBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            dietBox.setMaxHeight(274);
            dietBox.setMaxWidth(304);



            Image image = new Image(new ByteArrayInputStream(diet.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitHeight(275);
            picture.setFitWidth(300);



            Label dietName = new Label(diet.getDietName());
            dietName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            dietName.setWrapText(true);

            Label dietDescription = new Label(diet.getDietDescription());
            dietDescription.setStyle("-fx-font-size: 14;");
            dietDescription.setWrapText(true);

            Label dietCategory = new Label(diet.getDietCategory());
            dietCategory.setStyle("-fx-font-size: 14; -fx-text-fill: #666;");
            dietCategory.setWrapText(true);

            dietBox.getChildren().addAll(picture, dietName, dietDescription, dietCategory);

            dietBox.setOnMouseClicked(event -> goToDietDetails(diet));

            VBox.setVgrow(dietName, Priority.ALWAYS);
            VBox.setVgrow(dietDescription, Priority.ALWAYS);
            VBox.setVgrow(dietCategory, Priority.ALWAYS);

            dietContainer.getChildren().add(dietBox);
        }

        dietContainer.setSpacing(22);
        dietContainer.setFillHeight(false);
    }
}

