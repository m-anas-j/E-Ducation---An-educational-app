package education;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable{


    @FXML AnchorPane anchorPane = new AnchorPane();
    @FXML private Scene scene = new Scene(anchorPane);

    //Buttons
    @FXML private Button fullnameButton = new Button();
    @FXML private Button gradeButton = new Button();
    @FXML private Button instituteButton = new Button();
    @FXML private Button gobackButton = new Button();
    @FXML private Button changepasswordButton = new Button();
    @FXML private Button nextButton = new Button();
    @FXML private Button quizButton = new Button();

    //Text fields
    @FXML private TextField fullname = new TextField("anas");
    @FXML private TextField username = new TextField();
    @FXML private TextField grade = new TextField();
    @FXML private TextField institute = new TextField();
    @FXML private TextField skilllevel = new TextField();

    //Labels
    @FXML public Label changeSuccessful = new Label();

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("Setting user info");
        this.fullname.setText("        " + WelcomeScreenController._fullname);
        this.username.setText("         " + WelcomeScreenController._username);
        this.grade.setText("        " + WelcomeScreenController._grade);
        this.institute.setText("        " + WelcomeScreenController._institute);
        this.skilllevel.setText("        " + WelcomeScreenController._skilllevel);
    }

    //methods: setters

    @FXML public void setFullname(String fullname)
    {
        this.fullname.setText(fullname);
    }

    @FXML public void setUsername(String username)
    {
        this.username.setText(username);
    }

    @FXML public void setGrade(String grade)
    {
        this.grade.setText(grade);
    }

    @FXML public void setInstitute(String institute)
    {
        this.institute.setText(institute);
    }

    @FXML public void setSkilllevel(String skilllevel)
    {
        this.skilllevel.setText(skilllevel);
    }

    //methods: getters

    public TextField getFullname()
    {
        return fullname;
    }

    public String getUsername()
    {
        return username.getText();
    }

    public TextField getGrade()
    {
        return grade;
    }

    public TextField getInstitute()
    {
        return institute;
    }

    public String getSkilllevel()
    {
        return skilllevel.getText();
    }

    //methods: Button actions


    @FXML public  void fullnameButtonPressed() throws IOException
    {
        ChangeFullnameController fullnameChange = new ChangeFullnameController();
        fullnameChange.set_scene(Main.welscreen._password);
        fullnameChange.viewWindow();
    }

    @FXML public  void gradeButtonPressed() throws IOException
    {
        ChangeGradeController gradeChange = new ChangeGradeController();
        gradeChange.set_scene(Main.welscreen._password);
        gradeChange.viewWindow();
    }

    @FXML public  void instituteButtonPressed() throws IOException
    {
        ChangeInstituteController instituteChange = new ChangeInstituteController();
        instituteChange.set_scene(Main.welscreen._password);
        instituteChange.viewWindow();
    }

    @FXML public  void gobackButtonPressed()
    {
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public  void changepasswordButtonPressed() throws IOException
    {
        try
        {
            ChangePasswordController passwordChange = new ChangePasswordController();
            passwordChange.set_scene();
            passwordChange.viewWindow();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        //passwordChangeWindow.viewWindow();
    }

    @FXML public  void nextButtonPressed() throws IOException
    {
        if (grade.getText().equals("        5"))
        {
            System.out.println("Grade "+grade.getText());
            Main.grade1.set_scene();
            Main.mainWIndow.setScene(Main.grade1.get_scene());
            Main.mainWIndow.show();
        }
        else if (grade.getText().equals("        4"))
        {
            System.out.println("Grade "+grade.getText());
            Main.grade4.set_scene();
            Main.mainWIndow.setScene(Main.grade4.get_scene());
            Main.mainWIndow.show();
        }

    }

    @FXML public void quizButtonPressed() throws IOException
    {
        Main.quizSelectionScreen.set_scene();
        Main.mainWIndow.setScene(Main.quizSelectionScreen.get_scene());
        Main.mainWIndow.show();
    }

    public void set_scene() throws IOException
    {
        Parent rootUserProfileScreen = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        scene = new Scene(rootUserProfileScreen);
    }

    public Scene get_scene()
    {
        return scene;
    }





}
