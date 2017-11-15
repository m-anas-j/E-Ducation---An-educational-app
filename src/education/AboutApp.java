package education;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Modality;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutApp implements Initializable{


    @FXML Label label1 = new Label();
    @FXML Label label2 = new Label();
    @FXML Label label3 = new Label();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        label1.setText("Developer Name: Mohammad Anas Jawad\nInstitute: IUT\nDeveloped in: September, 2017\nContact email: jawad_anas@yahoo.com");
    }
}
