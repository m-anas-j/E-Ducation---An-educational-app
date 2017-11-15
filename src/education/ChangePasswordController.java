package education;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;


public class ChangePasswordController {

    //buttons and labels and password fields

    @FXML private Button submitButton = new Button();
    @FXML private PasswordField oldPasswordField = new PasswordField();
    @FXML private PasswordField newPasswordfield = new PasswordField();
    @FXML private PasswordField confirmPasswordField = new PasswordField();
    @FXML private Label wrongPassword = new Label();
    @FXML private Label doesntMatch = new Label();
    Scene scene;

    //button actions


    /*public ChangePasswordController() throws IOException
    {
        Parent rootchangePasswordWindow = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        scene = new Scene(rootchangePasswordWindow);
    }*/

    public void set_scene() throws IOException
    {
        Parent rootchangePasswordWindow = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        scene = new Scene(rootchangePasswordWindow);
    }

    public Scene get_scene()
    {
        return scene;
    }

    public void viewWindow()
    {
        Main.passwordChangeWindow = new Stage();
        Main.passwordChangeWindow.setScene(scene);
        Main.passwordChangeWindow.show();
    }

    @FXML public void submitButtonPressed()
    {
        if (oldPasswordField.getText().equals(WelcomeScreenController._password) && newPasswordfield.getText().equals(confirmPasswordField.getText()))
        {
            UserDatabase objectUserDatabase = new UserDatabase();
            objectUserDatabase.changeUserPassword(WelcomeScreenController._username,newPasswordfield.getText());
            System.out.println("Done");
            Main.passwordChangeWindow.close();
        }
        else if (!oldPasswordField.getText().equals(WelcomeScreenController._password))
        {
            doesntMatch.setVisible(false);
            wrongPassword.setVisible(true);
            oldPasswordField.clear();
            newPasswordfield.clear();
            confirmPasswordField.clear();
        }
        else
        {
            wrongPassword.setVisible(false);
            doesntMatch.setVisible(true);
            oldPasswordField.clear();
            newPasswordfield.clear();
            confirmPasswordField.clear();
        }
    }

}
