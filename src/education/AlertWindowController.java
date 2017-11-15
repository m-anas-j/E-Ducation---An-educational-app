package education;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class AlertWindowController implements Initializable {


    @FXML AnchorPane anchorPane = new AnchorPane();
    @FXML Label areYouSure = new Label();
    @FXML Button yesButton = new Button();
    @FXML Button noButton = new Button();
    @FXML Image image = new Image("/education/Assets/blankscreen.png");
    @FXML javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);
    @FXML Region region = new Region();

    @FXML public void yesButtonClicked()
    {
        Main.mainWIndow.close();
        Main.alertWindow.close();
        ;
    }


    @FXML public void noButtonClicked()
    {
        Main.alertWindow.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*imageView.fitWidthProperty().bind(anchorPane.widthProperty());
        imageView.fitHeightProperty().bind(anchorPane.widthProperty());
        noButton.prefWidthProperty().bind(anchorPane.widthProperty());*/

    }
}
