package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Projekt Okna");
        primaryStage.setScene(scene);

        primaryStage.setHeight(600d);
        primaryStage.setWidth(900d);
        primaryStage.getIcons().add(new Image("main/boar.png"));

        primaryStage.setOnCloseRequest((e) -> {
            MainWindowController.closeProgram();
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
