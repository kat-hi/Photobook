import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.*;

public class FxFrontend extends Application {
    public static Photoview photoview;
    //public static MenuTab menu;
    public static Browser browser;
    public static InfoBar info;
    public static Top top;
    public static Handler handler;

    static {
        try {
            handler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Logger filelog = Logger.getLogger("FxFrontend");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        DBController.connect();
        filelog.addHandler(handler);
        stage.setTitle("Photobook!");
        stage.setMaximized(true);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color : LIGHTGRAY");

        Scene scene = new Scene(root, 800, 600);
        filelog.info(filelog.getName() + ": scene created");
        stage.setTitle("Photobook");
        stage.setScene(scene);

        //menu = new MenuTab(stage);
        browser = new Browser(root);
        info = new InfoBar(root);
        photoview = new Photoview(root);
        top = new Top(root, stage);

        stage.show();
    }
}