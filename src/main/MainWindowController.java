package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Stage myStage;

    @FXML
    Label labelText;

    @FXML
    Button button1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelText.setText("program wystartowal");
    }

    public void buttonClicked() {
        labelText.setText("button zostal wcisniety");
    }

    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

    public void setStage(Stage stage) {
        myStage = stage;
    }
}
