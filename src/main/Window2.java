package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Wojciech Wasilewski
 * @date Created on 25.03.2019
 */
public class Window2 implements Initializable {

    Stage window2Stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void openWindow2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("fxmlfiles/window2.fxml"));

        @SuppressWarnings("Duplicates") //bajer zeby nie pokazywalo duplicate code
                Scene scene = new Scene(fxmlLoader.load());
        window2Stage = new Stage();
        window2Stage.setTitle("Window 2");
        window2Stage.setResizable(false);
        window2Stage.setScene(scene);
        window2Stage.show();
    }
}
