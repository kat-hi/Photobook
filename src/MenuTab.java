import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class visualizes the menu of this application.
 */
public class MenuTab extends HBox {
    private static Logger filelog = Logger.getLogger(MenuTab.class.getName());

    /**
     * This method is the constructor of this class using one parameter.
     * This constructor creates all menuitems and their eventListeners
     * @param stage this parameter is the javafx-component this class should be integrated in
     */
    public MenuTab(Stage stage) {
       filelog.addHandler(FxFrontend.filehandler);
        MenuBar menu = new MenuBar();
        menu.setStyle("-fx-background-color: SLATEGREY;");
        menu.setPadding(new Insets(15,0,15,0));

        this.setStyle("-fx-font-size: 15px; " +
                "-fx-background-color : SLATEGREY");

        // Create Menu
        Menu mainMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");
        Menu toolMenu = new Menu("Tools");
        Menu helpMenu = new Menu("Help");

        mainMenu.setStyle("-fx-min-width: 150px;");
        editMenu.setStyle("-fx-min-width: 150px;");
        viewMenu.setStyle("-fx-min-width: 150px;");
        toolMenu.setStyle("-fx-min-width: 150px;");
        helpMenu.setStyle("-fx-min-width: 150px;");

        // Create Menucontent
        MenuItem importFile = new MenuItem("Import File");
        MenuItem importDirectory = new MenuItem("Import Directory");
        MenuItem exit = new MenuItem("Exit");

        MenuItem undo = new MenuItem("Undo");
        MenuItem redo = new MenuItem("Redo");
        MenuItem selectAll = new MenuItem("Select All");

        MenuItem showInfobar = new MenuItem("Show Infobar");
        MenuItem showBrowserbar = new MenuItem("Show Browserbar");
        MenuItem sort = new MenuItem("Sort By");
        MenuItem zoomIn = new MenuItem("Zoom In");
        MenuItem zoomOut = new MenuItem("Zoom Out");
        MenuItem fullscreen = new MenuItem("Enter Fullscreen");

        MenuItem rotateCW = new MenuItem("Rotate Clockwise");
        MenuItem rotateCCW = new MenuItem("Rotate Counterclockwise");
        MenuItem flipH = new MenuItem("Flip Horizontally");
        MenuItem flipV = new MenuItem("Flip Vertically");

        MenuItem helpItem = new MenuItem("Get Help");

        CheckMenuItem off = new CheckMenuItem("Off");
        CheckMenuItem severe = new CheckMenuItem("Severe");
        CheckMenuItem warning = new CheckMenuItem("Warning");
        CheckMenuItem info = new CheckMenuItem("Info");
        CheckMenuItem config = new CheckMenuItem("Config");
        CheckMenuItem fine = new CheckMenuItem("Fine");
        CheckMenuItem finer = new CheckMenuItem("Finer");
        CheckMenuItem finest = new CheckMenuItem("Finest");
        CheckMenuItem all = new CheckMenuItem("All");

        Menu logMenu = new Menu("Set Log Level");
        logMenu.getItems().addAll(off, severe, warning, info, config, fine, finer, finest, all);

        mainMenu.getItems().addAll(importFile, importDirectory, exit);
        editMenu.getItems().addAll(undo, redo, selectAll);
        viewMenu.getItems().addAll(showInfobar, showBrowserbar, sort, zoomIn, zoomOut, fullscreen);
        toolMenu.getItems().addAll(rotateCW, rotateCCW, flipH, flipV);
        helpMenu.getItems().addAll(helpItem, logMenu);

        menu.getMenus().addAll(mainMenu,editMenu,viewMenu, toolMenu, helpMenu);
        this.getChildren().add(menu);
        filelog.info("Menu created");

        importFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load File");
            List<File> files = fileChooser.showOpenMultipleDialog(stage);
            FxFrontend.photoview.addImages(files);
            filelog.info("File loaded");
        });
        importFile.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));

        importDirectory.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Load Directory");
            File directoryPath = directoryChooser.showDialog(stage);
            File[] fileArray = directoryPath.listFiles();
            if (fileArray != null) {
                List<File> files = Arrays.asList(fileArray);
                FxFrontend.photoview.addImages(files);
            }
            filelog.info("Directory loaded");
        });
        importDirectory.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_ANY));

        exit.setOnAction(event -> {
            System.exit(0);
        });
        exit.setAccelerator(new KeyCodeCombination(KeyCode.ESCAPE));

        undo.setOnAction(event -> {
            undo.setStyle("-fx-font-size: 5px;");
            filelog.info("Undo clicked");
            InfoBar.showMenuSelection("Undo clicked");
        });

        redo.setOnAction(event -> {
            filelog.info("Redo clicked");
            InfoBar.showMenuSelection("Redo clicked");
        });

        selectAll.setOnAction(event -> {
            filelog.info("Select All clicked");
            InfoBar.showMenuSelection("Select All clicked");
        });

        showInfobar.setOnAction(event -> {
            filelog.info("Show Infobar clicked");
            InfoBar.showMenuSelection("Show Infobar clicked");
        });

        showBrowserbar.setOnAction(event -> {
            filelog.info("Show Browserbar clicked");
            InfoBar.showMenuSelection("Show Browserbar clicked");
        });

        sort.setOnAction(event -> {
            filelog.info("Sort By clicked");
            InfoBar.showMenuSelection("Sort By clicked");
        });

        zoomIn.setOnAction(event -> {
            filelog.info("Zoom In clicked");
            InfoBar.showMenuSelection("Zoom In clicked");
        });

        zoomOut.setOnAction(event -> {
            filelog.info("Zoom Out clicked");
            InfoBar.showMenuSelection("Zoom Out clicked");
        });

        fullscreen.setOnAction(event -> {
            filelog.info("Enter Fullscreen clicked");
            InfoBar.showMenuSelection("Enter Fullscreen clicked");
        });


        rotateCW.setOnAction(event -> {
            LoadedImage.currentImage.setRotate(LoadedImage.currentImage.getRotate() + 90);
        });

        rotateCCW.setOnAction(event -> {
            LoadedImage.currentImage.setRotate(LoadedImage.currentImage.getRotate() + 270);
        });

        flipH.setOnAction(event -> {
            filelog.info("Flip Horizontally clicked");
            InfoBar.showMenuSelection("Flip Horizontally clicked");
        });

        flipV.setOnAction(event -> {
            filelog.info("Flip Vertically clicked");
            InfoBar.showMenuSelection("Flip Vertically clicked");
        });

        helpItem.setOnAction(event -> {
            try {
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI uri = new java.net.URI("http://www.google.com");
                desktop.browse(uri);
            } catch (IOException e) {
                e.printStackTrace();
                filelog.log(Level.SEVERE, "Help Error IO", e);
            } catch (URISyntaxException e) {
                e.printStackTrace();
                filelog.log(Level.SEVERE, "Help Error URI", e);
            }
        });
        helpItem.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_ANY));

        off.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.OFF);
        });

        severe.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.SEVERE);
        });

        warning.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.WARNING);
        });

        info.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.INFO);
        });

        config.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.CONFIG);
        });

        fine.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.FINE);
        });

        finer.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.FINER);
        });

        finest.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.FINEST);
        });

        all.setOnAction(event -> {
            FxFrontend.filehandler.setLevel(Level.ALL);
        });
    }

}
