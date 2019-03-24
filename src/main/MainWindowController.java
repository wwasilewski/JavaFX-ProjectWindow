package main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
    static ToggleGroup tg; //do radiobuttonow zeby nie zaznaczaly sie razem

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    ImageView imageview, imageview2;

    @FXML
    Label labelText;

    @FXML
    Button button1, button2;

    @FXML
    TextField textField1;

    @FXML
    RadioButton female, male;

    @FXML
    CheckBox chk1;

    static ComboBox combo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelText.setText("program started");
        button1.setGraphic(new ImageView("main/exit.png")); //dodanie ikony do buttona
        button2.setGraphic(new ImageView("main/boar.png"));

        List<RadioButton> rblist = new ArrayList<>(); //tworze liste radiobuttonow
        rblist.add(female); //dodanie female do listy
        rblist.add(male);
        MainWindowController.prepareRadioButtons(rblist); //podpiecie metody do kontrolera - z moja lista radibuttonow
        chk1.setSelected(true); //ustawienie zaznaczenia na starcie
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

    public void checkboxClicked() {
        boolean checked = chk1.isSelected();
        if (checked) {
            textField1.appendText(" CheckBox selected");
        } else {
            textField1.appendText(" CheckBox NOT selected");
        }
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

    //metoda do wyswietlenia obrazu dzika i drugiego obrazu zamkniecia
    public void handleButtonAction(ActionEvent event) {
        Image image = new Image("main/boar.png");
        imageview.setImage(image);
        Image image2 = new Image("main/exit.png");
        imageview2.setImage(image2);
    }

    //metoda po to aby nie zasmiecac klasy MainWindow - dodajemy tu kontrolki
    public static void addControls(StackPane stackPane) {
        Label lbl = new Label();
        lbl.setText("TESTING LABEL");
        StackPane.setMargin(lbl, new Insets(380, 10, 10, 10));
        stackPane.getChildren().add(lbl);

        //tworze liste obiektow Cars zeby potem je dodac do ComboBoxa
        ObservableList<Cars> carsList = FXCollections.observableArrayList(
                new Cars("FI", "Fiat"),
                new Cars("FO", "Ford"),
                new Cars("ME", "Mercedes"),
                new Cars("VW", "Volkswagen")
        );

        combo = new ComboBox(carsList);

        //chce aby po wyborze zmienialo mi label TESTING LABEL na to co wybralem
        combo.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Cars>() { //trzeba recznie dodac te Cars i potem przyslonic metode ponownie
                    @Override
                    public void changed(ObservableValue<? extends Cars> observableValue, Cars cars, Cars t1) {
                        if (null != t1) {
                            if (null != cars) {
                                lbl.setText(t1.getName() + "(" + t1.getCode() + ") previousValue: " + cars);
                            } else {
                                lbl.setText(t1.getName() + "(" + t1.getCode() + ")");
                            }
                        }
                    }
                }
        );

        StackPane.setMargin(combo, new Insets(330, 10, 10, 10));
        stackPane.getChildren().add(combo);
    }
}
