import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class MenuTab extends HBox {

    private Button fileBtn;
    private Button dirBtn;
    private static Logger filelog = Logger.getLogger("MenuTab");

    public MenuTab(VBox root, Stage stage) {
        filelog.addHandler((FxFrontend.handler));

        HBox menubox = new HBox();
        MenuBar menu = new MenuBar();
        this.setStyle("-fx-min-height: 30px; " +
                "-fx-background-color : DARKGRAY");
        // Create Menu
        Menu mainMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");
        Menu toolMenu = new Menu("Tools");
        Menu helpMenu = new Menu("Help");

        mainMenu.setStyle("-fx-min-width: 80px;");
        editMenu.setStyle("-fx-min-width: 80px;");
        viewMenu.setStyle("-fx-min-width: 80px;");
        toolMenu.setStyle("-fx-min-width: 80px;");
        helpMenu.setStyle("-fx-min-width: 80px;");

        // Create Menucontent
        MenuItem importFile = new MenuItem("Import File");
        MenuItem importDirectory = new MenuItem("Import Directory");
        MenuItem openFiles = new MenuItem("Open Files");

        MenuItem undo = new MenuItem("Undo");
        MenuItem redo = new MenuItem("Redo");
        MenuItem selectAll = new MenuItem("Select All");
        MenuItem exit = new MenuItem("Exit");
        MenuItem helpItem = new MenuItem("Get Help");

        MenuItem showInfobar = new MenuItem("Show Infobar");  //toggle funktion implementieren
        MenuItem showBrowserbar = new MenuItem("Show Browserbar");
        MenuItem sort = new MenuItem("Sort By");
        MenuItem zoomIn = new MenuItem("Zoom In");
        MenuItem zoomOut = new MenuItem("Zoom Out");
        MenuItem fullscreen = new MenuItem("Enter Fullscreen");

        MenuItem rotateCW = new MenuItem("Rotate Clockwise");
        MenuItem rotateCCW = new MenuItem("Rotate Counterclockwise");
        MenuItem flipH = new MenuItem("Flip Horizontally");
        MenuItem flipV = new MenuItem("Flip Vertically");

        mainMenu.getItems().addAll(importFile, importDirectory);
        editMenu.getItems().addAll(undo, redo, selectAll, exit);
        viewMenu.getItems().addAll(showInfobar, showBrowserbar, sort, zoomIn, zoomOut, fullscreen);
        toolMenu.getItems().addAll(rotateCW, rotateCCW, flipH, flipV);
        helpMenu.getItems().add(helpItem);

        menu.getMenus().addAll(mainMenu,editMenu,viewMenu, toolMenu, helpMenu);
        this.getChildren().add(menu);
        //root.setAlignment(Pos.TOP_CENTER);

        // @refactoring function
        importFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg"));
            List<File> files = fileChooser.showOpenMultipleDialog(stage);
            FxFrontend.photoview.addImages(files);
        });

        // @ refactoring function
        importDirectory.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("load directory");
            File directoryPath = directoryChooser.showDialog(stage);
            File[] fileArray = directoryPath.listFiles();
            if (fileArray != null) {
                List<File> files = Arrays.asList(fileArray);
                FxFrontend.photoview.addImages(files);
            }
        });

        openFiles.setOnAction(event -> {

        });

        /*
        rotateCW.setOnAction(event -> {
           ImageView imageview = new ImageView(image);
            imageview.setRotate(imageview.getRotate() + 90);
        });
        */
    }

}
