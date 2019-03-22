package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import menu_util.MenuUtilities;

public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("mainWindow.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);

        MainWindowController controller = (MainWindowController) loader.getController();
        controller.setStage(primaryStage);

        stackPane.getChildren().add(MenuUtilities.prepareMenu());
        stackPane.setAlignment(Pos.TOP_LEFT);

        primaryStage.getIcons().add(new Image("main/boar.png"));
        primaryStage.setHeight(600d);
        primaryStage.setWidth(900d);
        primaryStage.setMinHeight(300d);
        primaryStage.setMinWidth(300d);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Projekt Okna");
        primaryStage.show();

        primaryStage.setOnCloseRequest((e) -> MainWindowController.closeProgram());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
