package education;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;




public class WelcomeScreenController {

    @FXML private  AnchorPane anchorPane = new AnchorPane();
    @FXML private  Scene welcomeScene = new Scene(anchorPane);
    @FXML private  TextField userTextField = new TextField();
    @FXML private PasswordField passTextField = new PasswordField();
    @FXML private  Button login = new Button();
    @FXML private  Button signup = new Button();
    @FXML private  Button exit = new Button();
    @FXML private  Button appInfo = new Button();
    @FXML private  Label wrongPassword = new Label();
    @FXML private  Label user = new Label();
    @FXML private  Label pass = new Label();
    @FXML Region region = new Region();

    static public String _fullname;
    static public String _username;
    static public String _password;
    static public String _institute;
    static public String _grade;
    static public String _skilllevel;



    public void set_scene() throws IOException
    {
        Parent rootWelcomeScreen = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        welcomeScene = new Scene(rootWelcomeScreen);
        region.prefWidthProperty().set(anchorPane.getWidth()/3.43);
    }

    public Scene get_scene()
    {
        return welcomeScene;
    }

    //Button actions

    @FXML public void loginButtonClicked() throws IOException
    {
        try
        {
            System.out.println("Logging in...");
            _username = userTextField.getText();
            //String _fullname,_password, _institute, _grade, _skilllevel;
            UserDatabase objectUserDatabase = new UserDatabase();
            objectUserDatabase.result = objectUserDatabase.statement.executeQuery("SELECT * FROM USERDATABASE WHERE USERNAME='" + _username + "'" );
            objectUserDatabase.result.next();
            //_password = objectUserDatabase.result.getString(3);
            _fullname = objectUserDatabase.result.getString(1);
            //_username= objectUserDatabase.result.getString(2);
            _password = objectUserDatabase.result.getString(3);
            _institute = objectUserDatabase.result.getString(4);
            _grade = objectUserDatabase.result.getString(5);
            _skilllevel = objectUserDatabase.result.getString(6);


           // objectUserDatabase.result = objectUserDatabase.statement.executeQuery("SELECT * FROM  USERDATABASE WHERE USERNAME='" + _username + "'" );

            if (passTextField.getText().equals(_password) && userTextField.getText().equals(_username))
            {
                System.out.println("Logged in");
                System.out.println(_fullname+" "+_username+" "+_grade+" "+_institute+" "+_skilllevel);
                Main.userProfileScreen.set_scene();
                Main.userProfileScreen.setFullname(_fullname);
                Main.userProfileScreen.setUsername(_username);
                Main.userProfileScreen.setGrade(_grade);
                Main.userProfileScreen.setInstitute(_institute);
                Main.userProfileScreen.setSkilllevel(_skilllevel);
                Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
                Main.mainWIndow.show();
            }
            else
            {
                System.out.println("Failed");
                wrongPassword.setVisible(true);
            }
            userTextField.clear();
            passTextField.clear();
        }
        catch(Exception e)
        {
            System.out.println(e);
            wrongPassword.setVisible(true);
            userTextField.clear();
            passTextField.clear();
        }
    }

    @FXML public void signupButtonClicked() throws IOException
    {
        /*Parent rootSignupScreen = FXMLLoader.load(getClass().getResource("SignupScreen.fxml"));
        Scene myScene = new Scene (rootSignupScreen,980,686);
        Main.mainWIndow.setScene(myScene);
        Main.mainWIndow.show();*/
        //ControllerSignup signupScreen = new ControllerSignup();
        Main.signupScreen.set_scene();
        Main.mainWIndow.setScene(Main.signupScreen.get_scene());
        Main.mainWIndow.show();


    }

    @FXML public void exitButtonClicked() throws IOException
    {
        Parent rootAlertWindow = FXMLLoader.load(getClass().getResource("AlertWindow.fxml"));
        Scene alertScene = new Scene(rootAlertWindow);
        Main.alertWindow = new Stage();
        Main.alertWindow.setTitle("Please don't go!! D':");
        Main.alertWindow.setScene(alertScene);
        Main.alertWindow.show();
    }

    @FXML public void appinfoClicked() throws IOException
    {
        Main.aboutApp = new Stage();
        Main.aboutApp.initModality(Modality.APPLICATION_MODAL);
        Main.aboutApp.setTitle("About the app");
        Parent rootAboutScene = FXMLLoader.load(getClass().getResource("AboutApp.fxml"));
        Scene aboutScene = new Scene(rootAboutScene);
        Main.aboutApp.setScene(aboutScene);
        Main.aboutApp.show();
    }

    @FXML public void makeWarningDisappear()
    {
        wrongPassword.setVisible(false);
    }






}
