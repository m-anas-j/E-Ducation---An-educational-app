package education;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizSelectionScreenController implements Initializable{


    @FXML private AnchorPane anchorPane = new AnchorPane();
    @FXML private ComboBox<String> comboBoxGrade4SubjectChapters = new ComboBox<>();
    @FXML private ComboBox<String> comboBoxGrade5SubjectChapters = new ComboBox<>();
    @FXML private ComboBox<String> comboBoxGrade4Subjects = new ComboBox<>();
    @FXML private ComboBox<String> comboBoxGrade5Subjects = new ComboBox<>();
    @FXML Button backButton = new Button();
    @FXML Button homeButton = new Button();
    Scene scene= new Scene(anchorPane);

    public void combBox4SubjectChapterSelect() throws IOException
    {


        System.out.println(comboBoxGrade4SubjectChapters.getValue());

        if (comboBoxGrade4SubjectChapters.getValue().equals("Chapter 1"))
        {
            QuestionScreenController.quizId="04En01";
        }

        Main.questionScreen.set_scene();
        Main.mainWIndow.setScene(Main.questionScreen.get_scene());
        Main.mainWIndow.show();


    }

    public void combBox5SubjectChapterSelect() throws IOException
    {


        System.out.println(comboBoxGrade4SubjectChapters.getValue());

        if (comboBoxGrade5SubjectChapters.getValue().equals("Chapter 1"))
        {
            QuestionScreenController.quizId="05Re01";
        }

        Main.questionScreen.set_scene();
        Main.mainWIndow.setScene(Main.questionScreen.get_scene());
        Main.mainWIndow.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        comboBoxGrade4Subjects.getItems().addAll("English","Math","Religion","ICT","Science");
        comboBoxGrade4SubjectChapters.getItems().addAll("Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5");
        comboBoxGrade5Subjects.getItems().addAll("English","Math","Social Science","History","Geography");
        comboBoxGrade5SubjectChapters.getItems().addAll("Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5");

        comboBoxGrade4Subjects.setOnAction(event ->
        {
            System.out.println(comboBoxGrade4Subjects.getValue());
            comboBoxGrade4SubjectChapters.setDisable(false);
        });

        comboBoxGrade4SubjectChapters.setOnAction(event ->
        {
            try
            {
                combBox4SubjectChapterSelect();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        });

        comboBoxGrade5Subjects.setOnAction(event ->
        {
            System.out.println(comboBoxGrade5Subjects.getValue());
            comboBoxGrade5SubjectChapters.setDisable(false);
            //comboBoxSelect();
            //chaptername = comboBox.getValue();
        });

        comboBoxGrade5SubjectChapters.setOnAction(event ->
        {
            try
            {
                combBox5SubjectChapterSelect();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        });
    }

    @FXML public void backButtonPressed()
    {
        Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public void homeButtonPressed()
    {
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.mainWIndow.show();
    }

    public void set_scene() throws IOException
    {
        Parent rootQuizSelectionScreen= FXMLLoader.load(getClass().getResource("QuizSelectionScreen.fxml"));
        scene = new Scene(rootQuizSelectionScreen);
    }

    public Scene get_scene()
    {
        return scene;
    }

}
