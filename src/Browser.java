import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.logging.Logger;

/**
 * This class visualizes the left part of this frontend. It shows all files that are loaded.
 * We had plans for an eventListener that opens the picture that is clicked in this list.
 * Now it is only a list without any functions.
 */
public class Browser extends VBox {
    private static Logger filelog = Logger.getLogger(Browser.class.getName());
    private static Text filelist;

    /**
     * This method is the default constructor.
     */
    public Browser() {
    }
    /**
     * This method is a constructor with one parameter.
     * @param root this parameter defines the javaFx-component this browser-class should be integrated in.
     */
    public Browser(BorderPane root) {
        filelog.addHandler(FxFrontend.filehandler);
        filelist = new Text("");
        root.setLeft(this);
        this.setStyle("-fx-min-width: 200px; " + "-fx-background-color : SLATEGREY;" + "-fx-font-size: 12px");
        this.getChildren().add(filelist);
        this.setPadding(new Insets(30,30,30,30));
        filelog.info("BrowserBar created");
    }

    /**
     * This method takes all images that are saved in currentImages and uses StringBuilder to create a list of filenames that is shown in the textfield
     */
    public static void showLoadedFiles() {
        StringBuilder files = new StringBuilder();
        for(LoadedImage lm : Photoview.currentImages) {
            String filename = lm.getName();
            files.append("\r").append(filename);
        }
        filelist.setText(files.toString());
    }
}