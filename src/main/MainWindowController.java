package main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
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
    Button window1, window2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //metoda do otwierania okna nr1
    public void openWindow1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("fxmlfiles/window1.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage = new Stage();
        stage.setTitle("Window 1");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    //metoda do otwierania okna nr2 - nieco inaczej niz przy oknie nr1
    public void openWindow2() throws IOException {
        Window2 window2 = new Window2();
        window2.openWindow2();
    }

    //metoda zamykajaca poprawnie program
    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }
}
