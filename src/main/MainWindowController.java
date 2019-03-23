package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Wojciech Wasilewski
 * @date Created on 21.03.2019
 */
public class MainWindowController implements Initializable {

    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    ImageView imageview;

    @FXML
    Label labelText;

    @FXML
    Button button1;

    @FXML
    Button button2;

    @FXML
    TextField textField1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelText.setText("program started");
        button1.setGraphic(new ImageView("main/exit.png")); //dodanie ikony do buttona
        button2.setGraphic(new ImageView("main/boar.png"));
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

    // metoda do wyswietlenia obrazu dzika
    public void handleButtonAction(ActionEvent event) {
        Image image = new Image("main/boar.png");
        imageview.setImage(image);
    }
}
