import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

import java.util.logging.*;

/**
 * This class launches the application and declares classes used to build this photobook frontend.
 */
public class FxFrontend extends Application {
    private static Logger filelog = Logger.getLogger(FxFrontend.class.getName());
    public static Photoview photoview;
    public static Browser browser;
    public static InfoBar info;
    public static Top top;
    public static Handler filehandler;
    public static BorderPane root;

    /**
     * This method is called when the FxApplication is started.
     * launch is a method of the application-class that extends FxFrontend
     *
     * @param args can be used for commandline arguments if needed
     */
    public static void main(String[] args) {
        try {
            filehandler = new FileHandler("log.txt");
            //  fh.setLevel(Level.ALL);
            filehandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
            filelog.log(Level.SEVERE, "File logger not working.", e);
        }
        launch(args);
    }

    /**
     * This method starts this application and is used to set up general attributes for the main window.
     * It instantiates objects - browser, info, photoview, top - used to create the layout.
     *
     * @param stage JavaFx runtime creates a stage object for starting this application.
     *              this object is needed to display all visual parts of this application
     *
     */
    @Override
    public void start(Stage stage) {
        filelog.addHandler(filehandler);
        stage.setMaximized(true);
        root = new BorderPane();
        root.setStyle("-fx-background-color : SLATEGREY");
        Scene scene = new Scene(root, 800, 600);
        filelog.info(filelog.getName() + ": scene created");
        stage.setTitle("Photobook");
        stage.setScene(scene);

        browser = new Browser(root);
        info = new InfoBar(root);
        photoview = new Photoview(root);
        top = new Top(root, stage);

        stage.show();
    }
}