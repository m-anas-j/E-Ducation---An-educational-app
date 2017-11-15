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


public class ChangeFullnameController {

    //buttons and labels and password fields

    @FXML private Button submitButton = new Button();
    @FXML private TextField fullnameTextField = new TextField();
    @FXML private PasswordField passwordField = new PasswordField();
    @FXML private Label wrongPassword = new Label();
    Scene scene;
    private static String password;

    //button actions


    /*public ChangePasswordController() throws IOException
    {
        Parent rootchangePasswordWindow = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        scene = new Scene(rootchangePasswordWindow);
    }*/

    public void set_scene(String _password) throws IOException
    {
        Parent rootchangeFullnameWindow = FXMLLoader.load(getClass().getResource("ChangeFullname.fxml"));
        scene = new Scene(rootchangeFullnameWindow);
        System.out.println("set scene password "+_password);
        password=_password;
        System.out.println("set scene password "+ password);

    }

    public Scene get_scene()
    {
        return scene;
    }

    public void viewWindow()
    {
        Main.fullnameChangeWindow = new Stage();
        Main.fullnameChangeWindow.setScene(scene);
        Main.fullnameChangeWindow.show();
    }

    @FXML public void submitButtonPressed() throws IOException
    {
        if(passwordField.getText().equals(password))
        {
            UserDatabase objectUserDatabase = new UserDatabase();
            objectUserDatabase.changeUserFullname(WelcomeScreenController._username,fullnameTextField.getText());
            WelcomeScreenController._fullname = fullnameTextField.getText();
            System.out.println("Done");
            Main.userProfileScreen.setFullname(fullnameTextField.getText());
            Main.userProfileScreen.set_scene();
            Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
            Main.fullnameChangeWindow.close();
        }
        else
        {
            wrongPassword.setVisible(true);
            fullnameTextField.clear();
            passwordField.clear();
        }
    }

}
