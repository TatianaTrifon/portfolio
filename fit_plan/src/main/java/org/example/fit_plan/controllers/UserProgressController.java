package org.example.fit_plan.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.fit_plan.dao.implimentations.*;
import org.example.fit_plan.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    private ScrollPane pageScrollPane;

    @FXML
    private VBox dietScrollContent,dishScrollContent,exerciseScrollContent;

    @FXML
    private HBox dietContainer,dishContainer,exerciseContainer;

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
    private AnchorPane contentPane;

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

        DietDAOImpl dietDAO = new DietDAOImpl();
        Diet diet = dietDAO.findDietByUserId(userAccount.getUserId());
        showDiets(diet);

        DishDAOImpl dishDAO = new DishDAOImpl();
        List<Dish> dishes = dishDAO.findDishByUserAccountId(userAccount.getUserId());
        showDishes(dishes);

        ExerciseDAOImpl exerciseDAO = new ExerciseDAOImpl();
        List<Exercise> exercises = exerciseDAO.findExerciseByUserAccountId(userAccount.getUserId());
        showExercises(exercises);

    }

    @FXML
    public void goToHome(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-account.fxml"));
        scene = new Scene(root.load());

        UserAccountController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToWorkout(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-exercise.fxml"));
        scene = new Scene(root.load());

        UserExerciseController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToDiets(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-diet.fxml"));


        scene = new Scene(root.load());

        UserDietController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void goToDish(ActionEvent event) throws IOException {

        root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/user-dish.fxml"));


        scene = new Scene(root.load());

        UserDishController controller = root.getController();
        controller.setUserId(userAccount.getUserId());

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


    @FXML
    public void saveProgress() {

        WeightDAOImpl weightDAO = new WeightDAOImpl();
        UserAccountDAOImpl userAccountDAO = new UserAccountDAOImpl();

        try {
            double newHeight = Double.parseDouble(heightField.getText());
            double newWeight = Double.parseDouble(weightField.getText());


            Weight newWeightEntry = new Weight(userAccount.getUserId(), newWeight, new Timestamp(System.currentTimeMillis()));
            weightDAO.create(newWeightEntry);

            userAccount.setHeight(newHeight);
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

    public void goToDietDetails(Diet diet){

        try {
            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/diet-details.fxml"));

            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            Stage dietDetailsStage = new Stage();
            dietDetailsStage.setScene(new Scene(root.load()));

            DietDetailsController controller = root.getController();
            controller.setDiet(diet);
            controller.setUserId(userAccount.getUserId());
            controller.setPreviousStage(currentStage);

            currentStage.hide();
            dietDetailsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void showDiets(Diet diet) {
        dietContainer.getChildren().clear();
        dietContainer.setSpacing(20);

        if (diet == null) {
            System.out.println("No diet found for the given user.");
            return;
        }

        VBox dietBox = new VBox(10);
        dietBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
        dietBox.setMaxHeight(278);
        dietBox.setMaxWidth(344);

        if (diet.getPicture() != null) {
            Image image = new Image(new ByteArrayInputStream(diet.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitHeight(275);
            picture.setFitWidth(340);
            dietBox.getChildren().add(picture);
        } else {
            System.out.println("No image available for this diet.");
        }

        Label dietName = new Label(diet.getDietName());
        dietName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        dietName.setWrapText(true);

        Label dietDescription = new Label(diet.getDietDescription());
        dietDescription.setStyle("-fx-font-size: 14;");
        dietDescription.setWrapText(true);

        Label dietCategory = new Label(diet.getDietCategory());
        dietCategory.setStyle("-fx-font-size: 14; -fx-text-fill: #666;");
        dietCategory.setWrapText(true);

        dietBox.getChildren().addAll(dietName, dietDescription, dietCategory);
        dietBox.setOnMouseClicked(event -> goToDietDetails(diet));

        dietContainer.setAlignment(Pos.CENTER);
        dietContainer.getChildren().addAll(dietBox);
    }


    public void goToDishDetails(Dish dish) {

        try {
            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/dish-details.fxml"));

            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            Stage dishDetailsStage = new Stage();
            dishDetailsStage.setScene(new Scene(root.load()));

            DishDetailsController controller = root.getController();
            controller.setDish(dish);
            controller.setUserId(userAccount.getUserId());
            controller.setPreviousStage(currentStage);

            currentStage.hide();
            dishDetailsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showDishes(List<Dish> dishes) {
        dishContainer.getChildren().clear();
        dishContainer.setSpacing(20);


        double dishBoxWidth = 350;
        double dishBoxHeight = 500;

        for (Dish dish : dishes) {
            VBox dishBox = new VBox(10);
            dishBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            dishBox.setPrefWidth(dishBoxWidth);
            dishBox.setPrefHeight(dishBoxHeight);
            dishBox.setMinWidth(dishBoxWidth);
            dishBox.setMinHeight(dishBoxHeight);
            dishBox.setMaxWidth(dishBoxWidth);
            dishBox.setMaxHeight(dishBoxHeight);

            dishBox.setClip(new Rectangle(dishBoxWidth , dishBoxHeight - 7));

            Image image = new Image(new ByteArrayInputStream(dish.getPicture()));
            ImageView picture = new ImageView(image);
            picture.setFitHeight(300);
            picture.setFitWidth(325);

            Label dietName = new Label(dish.getDishName());
            dietName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            dietName.setWrapText(true);



            Text ingredients = new Text(dish.getIngredients());
            ingredients.setStyle("-fx-font-size: 14;");
            ingredients.setWrappingWidth(280);



            Label calories = new Label(String.valueOf(dish.getCalories()) + "kcal");
            calories.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            calories.setWrapText(true);


            dishBox.getChildren().addAll(picture, dietName, ingredients,  calories);


            dishBox.setOnMouseClicked(event -> goToDishDetails(dish));

            dishContainer.getChildren().add(dishBox);
        }
    }

    public void goToExerciseDetails(Exercise exercise) {

        try {
            root = new FXMLLoader(getClass().getResource("/org/example/fit_plan/exercise-details.fxml"));

            Stage currentStage = (Stage) mainPane.getScene().getWindow();

            Stage dietDetailsStage = new Stage();
            dietDetailsStage.setScene(new Scene(root.load()));

            ExerciseDetailsController controller = root.getController();
            controller.setExercise(exercise);
            controller.setUserId(userAccount.getUserId());
            controller.setPreviousStage(currentStage);

            currentStage.hide();
            dietDetailsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void showExercises(List<Exercise> exercises) {

        exerciseContainer.getChildren().clear();

        if (exercises == null) {
            System.out.println("No exercise found for the given user.");
            return;
        }


        exerciseContainer.setSpacing(20);


        for (Exercise exercise : exercises) {
            VBox exerciseBox = new VBox(10);
            exerciseBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-padding: 10; -fx-background-color: #f9f9f9;");
            exerciseBox.setMaxHeight(302);
            exerciseBox.setMaxWidth(327);

            File tempFile = null;
            try {
                tempFile = File.createTempFile("exercise_video_", ".mp4");
                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(exercise.getVideo());
                }
                Media media = new Media(tempFile.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);
                mediaView.setFitHeight(300);
                mediaView.setFitWidth(325);
                mediaPlayer.setAutoPlay(true);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);



                exerciseBox.getChildren().add(mediaView);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (tempFile != null) {
                    tempFile.deleteOnExit();
                }
            }

            Label exerciseName = new Label(exercise.getExerciseName());
            exerciseName.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            exerciseName.setWrapText(true);

            Label sets = new Label("Sets: " + exercise.getSets());
            sets.setStyle("-fx-font-size: 16;");
            sets.setWrapText(true);

            Label exerciseDescription = new Label(exercise.getExerciseDescription());
            exerciseDescription.setStyle("-fx-font-size: 14;");
            exerciseDescription.setWrapText(true);

            exerciseBox.getChildren().addAll(exerciseName, sets, exerciseDescription);

            exerciseBox.setOnMouseClicked(event -> goToExerciseDetails(exercise));


            VBox.setVgrow(exerciseName, Priority.ALWAYS);
            VBox.setVgrow(sets, Priority.ALWAYS);
            VBox.setVgrow(exerciseDescription, Priority.ALWAYS);


            VBox.setMargin(exerciseContainer, new Insets(50, 0, 0, 0));
            VBox.setMargin(exerciseBox, new Insets(50, 0, 0, 0));

            exerciseContainer.getChildren().add(exerciseBox);
        }


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pageScrollPane.setFitToWidth(true);
        pageScrollPane.setFitToHeight(false);

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


        VBox mainContentVBox = new VBox(30);
        mainContentVBox.setPadding(new Insets(550, 20, 20, 20));


        mainContentVBox.getChildren().addAll(dietScrollContent, dishScrollContent, exerciseScrollContent);


        contentPane.getChildren().remove(mainContentVBox);
        contentPane.getChildren().add(mainContentVBox);

        heightField.setEditable(true);
        weightField.setEditable(true);
        activityComboBox.setDisable(false);
    }


}
