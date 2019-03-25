package main.windows;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Wojciech Wasilewski
 * @date Created on 25.03.2019
 */
public class Window2Controller implements Initializable {

    Stage window2Stage;

    @FXML
    Button window2Close;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //metoda do otwierania okna nr2 (wydzielona z MainWindowController)
    @SuppressWarnings("Duplicates") //bajer zeby nie pokazywalo duplicate code
    public void openWindow2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxmlfiles/window2.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        window2Stage = new Stage();
        window2Stage.setTitle("Window 2");

        //by okno bylo modalne (nie mozna nic zrobic w apce dopoki sie go nie zamknie)
        window2Stage.initModality(Modality.APPLICATION_MODAL);
        window2Stage.setResizable(false);
        window2Stage.setScene(scene);
        window2Stage.show();
    }

    //metoda do zamykania okna nr3
    public void closeWindow2() {
        //trzeba podac dokladnie o ktory stage chodzi, o ktora scene i ktore okno dlatego tak sie to robi
        window2Stage = (Stage) window2Close.getScene().getWindow();
        window2Stage.close();
    }
}
