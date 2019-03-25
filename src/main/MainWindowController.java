package main;

import javafx.application.Platform;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //metoda zamykajaca poprawnie program
    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }
}
