package education;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;


public class Grade4ScreenController {

    Scene scene;

    //buttons
    @FXML Button english = new Button();
    @FXML Button religion = new Button();
    @FXML Button math = new Button();
    @FXML Button science = new Button();
    @FXML Button ict = new Button();
    @FXML Button back = new Button();
    @FXML Button home = new Button();


    //setting and getting scene

    void set_scene() throws  IOException
    {
        Parent rootGrade4Window = FXMLLoader.load(getClass().getResource("Grade4Screen.fxml"));
        scene = new  Scene(rootGrade4Window);
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
        Main.grade4english.set_scene();
        Main.mainWIndow.setScene(Main.grade4english.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void ictClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade4ICT.set_scene();
        Main.mainWIndow.setScene(Main.grade4ICT.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void mathClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade4math.set_scene();
        Main.mainWIndow.setScene(Main.grade4math.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void scienceClicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade4science.set_scene();
        Main.mainWIndow.setScene(Main.grade4science.get_scene());
        Main.mainWIndow.show();
    }
    @FXML public void religionclicked() throws IOException
    {
        System.out.println("Trying to set up scene");
        Main.grade4religion.set_scene();
        Main.mainWIndow.setScene(Main.grade4religion.get_scene());
        Main.mainWIndow.show();
    }

}
