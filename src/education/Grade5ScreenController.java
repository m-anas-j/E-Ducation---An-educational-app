package education;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;


public class Grade5ScreenController {

    Scene scene;

    //buttons
    @FXML Button english = new Button();
    @FXML Button geography = new Button();
    @FXML Button math = new Button();
    @FXML Button socialscience = new Button();
    @FXML Button history = new Button();
    @FXML Button back = new Button();
    @FXML Button home = new Button();


    //setting and getting scene

    void set_scene() throws  IOException
    {
        Parent rootGrade1Window = FXMLLoader.load(getClass().getResource("Grade5Screen.fxml"));
        scene = new  Scene(rootGrade1Window);
    }

    Scene get_scene()
    {
        return scene;
    }

    //actions of buttons

    @FXML public void backButtonClicked()
    {
        Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public void homeButtonClicked()
    {
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void englishClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade5english.set_scene();
        Main.mainWIndow.setScene(Main.grade5english.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void geographyClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade5geography.set_scene();
        Main.mainWIndow.setScene(Main.grade5geography.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void mathClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade5math.set_scene();
        Main.mainWIndow.setScene(Main.grade5math.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void socialscienceClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade5socialscience.set_scene();
        Main.mainWIndow.setScene(Main.grade5socialscience.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void historyclicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade5history.set_scene();
        Main.mainWIndow.setScene(Main.grade5history.get_scene());
        Main.mainWIndow.show();
    }

}
