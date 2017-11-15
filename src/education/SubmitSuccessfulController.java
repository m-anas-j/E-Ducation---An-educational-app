package education;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class SubmitSuccessfulController {
    @FXML private Button ok = new Button();
    @FXML Label success = new Label();
    @FXML public void okButtonPressed() throws IOException
    {
        Main.submitWindow.setTitle("Congrats! :D");
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.submitWindow.close();
        Main.mainWIndow.show();
    }
}
