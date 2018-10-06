package education;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ChangeGradeController implements Initializable{

    //buttons and labels and password fields

    @FXML private Button submitButton = new Button();
    @FXML private TextField gradeTextField = new TextField();
    @FXML private PasswordField passwordField = new PasswordField();
    @FXML private Label wrongPassword = new Label();
    @FXML ComboBox<String> gradeCombobox = new ComboBox<>();
    Scene scene;
    private static String password;

    //button actions


    /*public ChangePasswordController() throws IOException
    {
        Parent rootchangePasswordWindow = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        scene = new Scene(rootchangePasswordWindow);
    }*/


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gradeCombobox.getItems().addAll("4","5");
    }

    public void set_scene(String _password) throws IOException
    {
        Parent rootchangeGradeWindow = FXMLLoader.load(getClass().getResource("ChangeGrade.fxml"));
        scene = new Scene(rootchangeGradeWindow);
        password=_password;
    }

    public Scene get_scene()
    {
        return scene;
    }

    public void viewWindow()
    {
        Main.gradeChangeWindow = new Stage();
        Main.gradeChangeWindow.setScene(scene);
        Main.gradeChangeWindow.show();
    }

    @FXML public void submitButtonPressed() throws IOException
    {
        if(passwordField.getText().equals(password))
        {
            UserDatabase objectUserDatabase = new UserDatabase("mayosenpai","mayosenpai");
            objectUserDatabase.changeGrade(WelcomeScreenController._username,gradeCombobox.getValue());
            WelcomeScreenController._grade = gradeCombobox.getValue();
            System.out.println("Done");
            Main.userProfileScreen.setGrade(gradeTextField.getText());
            Main.gradeChangeWindow.close();
            Main.userProfileScreen.set_scene();
            Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
        }
        else
        {
            wrongPassword.setVisible(true);
            gradeTextField.clear();
            passwordField.clear();
        }
    }

}
