import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import static java.nio.file.Files.probeContentType;

public class InfoBar extends VBox {
    private static Text filename;
    private static Text filemimetype;
    private static Logger filelog = Logger.getLogger("Infobar");

    public InfoBar(BorderPane root) {
        filelog.addHandler((FxFrontend.handler));
        this.setStyle("-fx-min-width: 200px; " +
                "-fx-background-color : GRAY");
        filename = new Text("");
        filemimetype = new Text("");

        filename.setFont(Font.font("Verdana", 15));
        filename.setVisible(true);
        filename.setStyle("-fx-bordercolor: black");
        filelog.info("Infobar created");
        root.setRight(this);
        this.setPadding(new Insets(50,60,50,10));
        this.getChildren().addAll(filename, filemimetype);

        this.setAlignment(Pos.BASELINE_RIGHT);
    }

    public static void showDetails(String filepath) {
        File file = new File(filepath);
        filename.setText(file.getName());
        Path path = Paths.get(filepath);
        String mimetype ="";
        try {
            mimetype = probeContentType(path);
        } catch (IOException IO) {
            filelog.info("IO Exception");
        }

        filemimetype.setText(mimetype);
    }
}
