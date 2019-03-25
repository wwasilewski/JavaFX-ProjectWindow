package main.windows;

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
 * @date Created on 25.03.2019
 */
public class Window1Controller implements Initializable {
    Stage window1Stage;

    @FXML
    Button window1Close;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //metoda do otwierania okna nr1 (wydzielona z MainWindowController)
    @SuppressWarnings("Duplicates")
    public void openWindow1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxmlfiles/window1.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        window1Stage = new Stage();
        window1Stage.setTitle("Window 1");
        window1Stage.setResizable(true);
        window1Stage.setScene(scene);
        window1Stage.show();
    }

    //metoda do zamykania okna nr1
    public void closeWindow1() {
        window1Stage = (Stage) window1Close.getScene().getWindow();
        window1Stage.close();
    }
}
