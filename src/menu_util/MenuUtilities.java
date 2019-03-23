package menu_util;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import main.MainWindowController;

/**
 * @author Wojciech Wasilewski
 * @date Created on 22.03.2019
 */
public class MenuUtilities {
    public static MenuBar prepareMenu() {

        MenuBar menuBar = new MenuBar(); //tworzy sam pasek menu

        Menu plikMenu = new Menu("File"); //tworzy element "Plik"
        MenuItem plikZamknij = new MenuItem("Close"); //tworzy element "Zamknij" dla "Plik"
        plikZamknij.setGraphic(new ImageView("main/exit.png")); //dodanie ikony do Zamknij
        plikZamknij.setOnAction(e -> MainWindowController.closeProgram()); //dodanie akcji do Zamknij

        plikMenu.getItems().add(plikZamknij); //dodaje element "Zamknij" do "Plik"
        menuBar.getMenus().add(plikMenu); //dodaje element "Plik" do paska menu

        return menuBar;
    }
}
