package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.Dish;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDietController implements Initializable {

    @FXML
    private ImageView exitImage, menuImage, homeView, workoutView, dietsView, dishView, progressView, settingsView, logOutView;

    @FXML
    private AnchorPane mainPane, iconPane, buttonsPane, caloriesResultPane;

    @FXML
    ScrollPane pageScrollPane;

    @FXML
    private VBox scrollContent;

    @FXML
    private HBox dietContainer;

    @FXML
    private JFXButton homeButton,workoutButton,dietsButton,dishButton,progressButton,settingsButton,logOutButton;

    @FXML
    private ComboBox<String> categoryComboBox;

    private String[] dietCategories = {"Weight-Loss Diets", "Diabetes Diets", "Healthy eating Diets", "Plant-Based Diets", "Bone and Joint health diets", "Heart-healthy Diets", "All"};

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    private int userId;



    public void setUserId(int userId) {
        this.userId = userId;

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
    public void goToDish(){}

    @FXML
    public void goToProgress(){}

    @FXML
    public void goToSettings(){}

    @FXML
    public void goToSignIn(){}


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



    @FXML
    public void chooseCategory(){

            DietDAOImpl dietDAOImpl = new DietDAOImpl();
            String selectedCategory = categoryComboBox.getValue();
            List<Diet> diets = new ArrayList<>();

            if(selectedCategory.equals("All")){
                diets = dietDAOImpl.findAllDiets();
                showDiets(diets);
            } else {
                diets = dietDAOImpl.findDietsByCategory(selectedCategory);
                showDiets(diets);

            }

    }

    public void showDiets(List<Diet> diets) {
        dietContainer.getChildren().clear();

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

        Image diets = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\diets.png");
        dietsView.setImage(diets);

        Image workout = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\workoutPlan.png");
        workoutView.setImage(workout);

        Image dish = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\dishIdeas.png");
        dishView.setImage(dish);

        Image progress = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\progress.png");
        progressView.setImage(progress);

        Image settings = new Image("file:/C:\\Users\\User\\IdeaProjects\\portfolio\\fit_plan\\src\\main\\java\\org\\example\\fit_plan\\images\\settings.png");
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

        for(int i = 0; i<dietCategories.length; i ++){
            categoryComboBox.getItems().add(dietCategories[i]);
        }

        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        List<Diet> dietsList = dietDAOImpl.findAllDiets();
        showDiets(dietsList);

        categoryComboBox.setOnAction(event -> chooseCategory());

    }
}
