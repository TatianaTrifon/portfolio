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
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.DietDAOImpl;
import org.example.fit_plan.dao.implimentations.UserAccountDAOImpl;
import org.example.fit_plan.model.Diet;
import org.example.fit_plan.model.Dish;
import org.example.fit_plan.model.UserAccount;

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
    private FlowPane dietContainer;

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

        UserAccountController controller = root.getController();
        controller.setUserId(userId);

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

        dietContainer.setHgap(20); // Horizontal gap between items
        dietContainer.setVgap(20); // Vertical gap between items
        dietContainer.setPrefWrapLength(pageScrollPane.getWidth() - 40); // Adjust wrap length based on ScrollPane width with padding

        for (Diet diet : diets) {
            VBox dietBox = new VBox(10);
            dietBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            dietBox.setMaxWidth(300);
            dietBox.setPrefWidth(300);

            Image image = new Image(new ByteArrayInputStream(diet.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitHeight(200);
            picture.setFitWidth(280);

            Label dietName = new Label(diet.getDietName());
            dietName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            dietName.setWrapText(true);


            Label dietCategory = new Label(diet.getDietCategory());
            dietCategory.setStyle("-fx-font-size: 14; -fx-text-fill: #666;");
            dietCategory.setWrapText(true);

            dietBox.getChildren().addAll(picture, dietName, dietCategory);
            dietBox.setOnMouseClicked(event -> goToDietDetails(diet));

            dietContainer.getChildren().add(dietBox);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pageScrollPane.setFitToWidth(true);
        pageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


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

        for(int i = 0; i<dietCategories.length; i ++){
            categoryComboBox.getItems().add(dietCategories[i]);
        }

        DietDAOImpl dietDAOImpl = new DietDAOImpl();
        List<Diet> dietsList = dietDAOImpl.findAllDiets();
        showDiets(dietsList);

        categoryComboBox.setOnAction(event -> chooseCategory());

    }
}
