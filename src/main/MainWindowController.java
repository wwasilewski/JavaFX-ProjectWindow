package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Stage myStage;

    @FXML
    ImageView imageview;

    @FXML
    Label labelText;

    @FXML
    Button button1;

    @FXML
    Button button2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelText.setText("program started");
    }

    //metoda do zmiany tekstu po kliknieciu buttona
    public void buttonClicked() {
        labelText.setText("button was clicked");
    }

    //metoda zamykajaca poprawnie program
    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

    //metoda ktora byla mi potrzebna w tutorialu - bez tego nie dziala
    public void setStage(Stage stage) {
        myStage = stage;
    }

    // metoda do wyswietlenia obrazu dzika
    public void handleButtonAction(ActionEvent event) {
        Image image = new Image("main/boar.png");
        imageview.setImage(image);
    }
}
