import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Browser extends VBox {
    private static Logger filelog = Logger.getLogger("Browser");

    public Browser(BorderPane root) {
        filelog.addHandler((FxFrontend.handler));

        root.setLeft(this);
        this.setStyle("-fx-min-width: 200px; " +
                "-fx-background-color : DARKGRAY");
        filelog.info("BrowserBar created");
    }
}
