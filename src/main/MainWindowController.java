package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    Button button1, button2;

    @FXML
    TextField textField1;

    @FXML
    RadioButton female, male;

    static ToggleGroup tg; //do radiobuttonow zeby nie zaznaczaly sie razem

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelText.setText("program started");
        button1.setGraphic(new ImageView("main/exit.png")); //dodanie ikony do buttona
        button2.setGraphic(new ImageView("main/boar.png"));

        List<RadioButton> rblist = new ArrayList<>(); //tworze liste radiobuttonow
        rblist.add(female); //dodanie female do listy
        rblist.add(male);
        MainWindowController.prepareRadioButtons(rblist); //podpiecie metody do kontrolera - z moja lista radibuttonow
    }

    //metoda do wrzucenia radiobuttonow do listy zeby mozna bylo zaznaczyc tylko 1 opcje
    //wygodne bo jak bedzie wiecej buttonow to latwo je dodac potem tylko w FXML i w initialize()
    //metoda statyczna zebym mogl sie do niej dostac w metodzie initialize()
    private static void prepareRadioButtons(List<RadioButton> rblist) {
        tg = new ToggleGroup();
        for (RadioButton rb : rblist) {
            rb.setToggleGroup(tg);
        }
    }

    //metoda do sprawdzenia czy radiobutton zostal klikniety
    public void radioClicked() {
        RadioButton selectedRB = (RadioButton) tg.getSelectedToggle();
        String clicked = selectedRB.getId();
        String clickedName = selectedRB.getText();

        textField1.setText("Id: " + clicked + ", " + "Name: " + clickedName);

    }

    //metoda do zmiany tekstu po kliknieciu buttona
    public void buttonClicked() {
        String txtFromTextField = textField1.getText();
        labelText.setText("button was clicked and " + txtFromTextField); //dodanie wpisanego tekstu do labela
        textField1.setText(""); //wyczyszczenie pola tekstowego po kliknieciu
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
