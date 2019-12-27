import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.util.logging.Logger;

public class Browser extends VBox {
    private static Logger filelog = Logger.getLogger("Browser");
    private static Text filelist;


    public Browser(BorderPane root) {
        filelog.addHandler(FxFrontend.handler);
        filelist = new Text("");
        root.setLeft(this);
        this.setStyle("-fx-min-width: 200px; " + "-fx-background-color : GRAY;");
        this.getChildren().add(filelist);
        this.setPadding(new Insets(30,30,30,30));
        filelog.info("BrowserBar created");
    }

    public static void showLoadedFiles() {
        StringBuilder files = new StringBuilder();
        for(LoadedImage lm : Photoview.currentImages) {
            String filename = lm.getName();
            files.append(filename).append("\r");
        }
        filelist.setText(String.valueOf(files));
    }
}