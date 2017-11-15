package education;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSignup implements Initializable{

    User newUser = new User();


    @FXML private Button backButton = new Button();
    @FXML private Button homeButton = new Button();
    @FXML private Button submitButton = new Button();
    @FXML private Button nextButton = new Button();
    @FXML AnchorPane anchorPane = new AnchorPane();
    @FXML private Scene scene = new Scene(anchorPane);
    @FXML private TextField fullnameTextfield = new TextField();
    @FXML private TextField userTextfield = new TextField();
    @FXML private PasswordField passTextField = new PasswordField();
    @FXML private PasswordField confirmPassTextField = new PasswordField();
    @FXML private TextField gradeTextFiled = new TextField();
    @FXML private TextField instituteTextField = new TextField();
    @FXML Label doesntMatch = new Label();
    @FXML Label fillAllFields = new Label();
    @FXML Label tooSmall = new Label();
    @FXML ComboBox<String> gradeCombobox = new ComboBox<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gradeCombobox.getItems().addAll("4","5");
    }

    public void set_scene() throws  IOException
    {
        Parent rootSignupScreen = FXMLLoader.load(getClass().getResource("SignupScreen.fxml"));
        scene = new Scene(rootSignupScreen);
    }

    public Scene get_scene()
    {
        return scene;
    }

    //button actions

    @FXML public void backButtonClicked() throws IOException
    {
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public void submitButtonPressed() throws IOException
    {
        doesntMatch.setVisible(false);
        fillAllFields.setVisible(false);


        if (passTextField.getText().length()<6)
        {
            System.out.println("Too small");
            tooSmall.setVisible(true);
        }

        else if(fullnameTextfield.getText().equals("") || userTextfield.getText().equals("") || instituteTextField.getText().equals(""))
        {
            fillAllFields.setVisible(true);
        }

        else if(passTextField.getText().equals(confirmPassTextField.getText()))
        {
            User newUser = new User();
            UserDatabase objectUserDatabase = new UserDatabase();
            newUser.setFullname(fullnameTextfield.getText());
            newUser.setUsername(userTextfield.getText());
            newUser.setPassword(passTextField.getText());
            //newUser.setGrade(Integer.parseInt(gradeTextFiled.getText()));
            newUser.setGrade(Integer.parseInt(gradeCombobox.getValue()));
            newUser.setInstitute(instituteTextField.getText());
            System.out.println(newUser.getUsername()+" "+newUser.getPassword());
            objectUserDatabase.setUserValues(newUser);


            Parent rootSubmitWindow = FXMLLoader.load(getClass().getResource("SubmitSuccessful.fxml"));
            Scene submitScene = new Scene(rootSubmitWindow);
            Main.submitWindow= new Stage();
            Main.submitWindow.setScene(submitScene);
            Main.submitWindow.show();
        }

        else
        {
            System.out.println(fullnameTextfield.getText());
            doesntMatch.setVisible(true);
            passTextField.clear();
            confirmPassTextField.clear();
        }
    }

    @FXML public void setDoesntMatchVisibility()
    {
        doesntMatch.setVisible(false);
    }



}
