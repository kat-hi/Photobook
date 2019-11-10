import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

// https://o7planning.org/de/11125/anleitung-javafx-menu

public class MenuTab extends HBox {

    private Button fileBtn;
    private Button dirBtn;

    public MenuTab(BorderPane root, Stage stage) {
        System.out.println("Create MenuTab");

        MenuBar menu = new MenuBar();
        // Create Menu
        Menu mainMenu = new Menu("Menu");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Create Menucontent
        MenuItem importFile = new MenuItem("Import File");
        MenuItem importDirectory = new MenuItem("Import Directory");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem helpItem = new MenuItem("Get Help");

        mainMenu.getItems().addAll(importFile, importDirectory);
        editMenu.getItems().add(exitItem);
        helpMenu.getItems().add(helpItem);

        menu.getMenus().addAll(mainMenu,editMenu,helpMenu);
        this.getChildren().add(menu);
        root.setTop(menu);

        importFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            String filepath = fileChooser.showOpenDialog(stage).getPath();
            System.out.println(filepath);
            if(!filepath.equals("")){
                FxFrontend.photoview.addImage(0,0, filepath);
            }
        });

        importDirectory.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("load directory");
            File directoryPath = directoryChooser.showDialog(stage);
            FxFrontend.photoview.addImages(directoryPath);
        });
    }
}
