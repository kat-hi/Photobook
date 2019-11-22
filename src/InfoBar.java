import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class InfoBar extends VBox {
    private static Logger filelog = Logger.getLogger("Infobar");

    public InfoBar(BorderPane root) {
        filelog.addHandler((FxFrontend.handler));

        root.setRight(this);

        this.setStyle("-fx-min-width: 200px; " +
                "-fx-background-color : DARKGRAY");
        filelog.info("Infobar created");
    }
}
