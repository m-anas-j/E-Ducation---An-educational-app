package education;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {










    static Stage mainWIndow;
    static Stage alertWindow;
    static Stage submitWindow;
    static Stage passwordChangeWindow;
    static Stage fullnameChangeWindow;
    static Stage gradeChangeWindow;
    static Stage instituteChangeWindow;
    static Stage aboutApp;


    static ControllerSignup signupScreen = new ControllerSignup();
    static WelcomeScreenController welscreen = new WelcomeScreenController();
    static Grade5ScreenController grade1 = new Grade5ScreenController();
    static Grade5EnglishController grade5english = new Grade5EnglishController();
    static Grade5GeographyController grade5geography = new Grade5GeographyController();
    static Grade5MathController grade5math = new Grade5MathController();
    static Grade5SocialscienceController grade5socialscience = new Grade5SocialscienceController();
    static Grade5HistoryController grade5history = new Grade5HistoryController();
    static Grade4ScreenController grade4 = new Grade4ScreenController();
    static Grade4MathController grade4math = new Grade4MathController();
    static Grade4EnglishController grade4english = new Grade4EnglishController();
    static Grade4ICTController grade4ICT = new Grade4ICTController();
    static Grade4ReligionController grade4religion = new Grade4ReligionController();
    static Grade4ScienceController grade4science = new Grade4ScienceController();
    static UserProfileController userProfileScreen = new UserProfileController();
    static QuizSelectionScreenController quizSelectionScreen = new QuizSelectionScreenController();
    static QuestionScreenController questionScreen = new QuestionScreenController();

    Scene myScene;
    Scene closingAlertScene;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        //Preparing exit screen for clicking the cross button

        Parent rootAlertWindow = FXMLLoader.load(getClass().getResource("AlertWindow.fxml"));
        closingAlertScene = new Scene(rootAlertWindow);

        //preparing main window


        mainWIndow=primaryStage;
        Parent rootWelcomeScreen = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));





        primaryStage.setOnCloseRequest(event ->
        {
            event.consume();
            alertWindow = new Stage();
            alertWindow.setTitle("Please don't go!! D':");
            alertWindow.setScene(closingAlertScene);
            alertWindow.show();
        });

        primaryStage.setTitle("Welcome Screen");
        //myScene=new Scene(rootWelcomeScreen,980,686);

        welscreen.set_scene();
        primaryStage.setScene( welscreen.get_scene());

        primaryStage.show();


        //Buttons actions

    }






}
