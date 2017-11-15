package education;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.BufferedReader;
import java.io.FileReader;

public class Grade5EnglishController implements Initializable {
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    @FXML
    private Scene scene = new Scene(anchorPane);
    @FXML
    private ComboBox<String> comboBox = new ComboBox<>();
    @FXML
    private TextArea textArea = new TextArea();
    @FXML
    private Button backButton = new Button();
    @FXML
    private Button homeButton = new Button();
    BufferedReader br;


    public void set_scene() throws IOException {
        System.out.println("Grade 5 scene set successful");
        Parent rootGrade5EnglishScene = FXMLLoader.load(getClass().getResource("Grade5English.fxml"));
        scene = new Scene(rootGrade5EnglishScene);

    }

    public Scene get_scene() {
        System.out.println("Returning grade 5 scene");
        return scene;
    }

    public void comboBoxSelect() {
        try {
            // br = new BufferedReader(new FileReader("C:\\Users\\Weisslogia\\IdeaProjects\\E-Ducation\\src\\education\\Assets\\Textbooks\\Grade 5\\English\\Chapter 1.txt"));
            br = new BufferedReader(new FileReader("C:\\Users\\Weisslogia\\IdeaProjects\\E-Ducation\\src\\education\\Assets\\Textbooks\\Grade 5\\English\\" + comboBox.getValue() + ".txt"));
            String prevlines = "";
            String newlines;
            while ((newlines = br.readLine()) != null) {
                //prevlines = newlines;
                textArea.setText(prevlines + "\n" + newlines);
                prevlines = textArea.getText();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML public void backButtonPressed()
    {
        Main.mainWIndow.setScene(Main.grade1.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public void homeButtonPressed()
    {
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.mainWIndow.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        String chaptername;
        comboBox.getItems().addAll("Contents","Chapter 1","Chapter 2","Chapter 3","Chapter 4","Chapter 5");
        comboBox.setOnAction(event ->
        {
            System.out.println(comboBox.getValue());
            comboBoxSelect();
            //chaptername = comboBox.getValue();
        });




    }
}

