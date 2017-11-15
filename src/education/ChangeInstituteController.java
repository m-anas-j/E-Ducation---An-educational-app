package education;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ChangeInstituteController {

    //buttons and labels and password fields

    @FXML private Button submitButton = new Button();
    @FXML private TextField instituteTextField = new TextField();
    @FXML private PasswordField passwordField = new PasswordField();
    @FXML private Label wrongPassword = new Label();
    Scene scene;
    private static String password;


    public void set_scene(String _password) throws IOException
    {
        Parent rootchangeInstituteWindow = FXMLLoader.load(getClass().getResource("ChangeInstitute.fxml"));
        scene = new Scene(rootchangeInstituteWindow);
        password=_password;
    }

    public Scene get_scene()
    {
        return scene;
    }

    public void viewWindow()
    {
        Main.instituteChangeWindow = new Stage();
        Main.instituteChangeWindow.setScene(scene);
        Main.instituteChangeWindow.show();
    }

    @FXML public void submitButtonPressed() throws IOException
    {
        if(passwordField.getText().equals(password))
        {
            UserDatabase objectUserDatabase = new UserDatabase();
            objectUserDatabase.changeInstitute(WelcomeScreenController._username,instituteTextField.getText());
            WelcomeScreenController._institute = instituteTextField.getText();
            System.out.println("Done");
            Main.instituteChangeWindow.close();
            Main.userProfileScreen.set_scene();
            Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
        }
        else
        {
            wrongPassword.setVisible(true);
            instituteTextField.clear();
            passwordField.clear();
        }
    }

}
