import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Top extends VBox {
    private static Logger filelog = Logger.getLogger("Top");

    public Top(BorderPane root, Stage stage){
        filelog.addHandler((FxFrontend.handler));

        VBox top = new VBox();
        root.setTop(this);

        MenuTab menu = new MenuTab(top, stage);
        //Filter filter = new Filter(top);
        this.getChildren().add(menu);
        this.setStyle("-fx-background-color : green");

        menu.setAlignment(Pos.TOP_CENTER);
        //filter.setAlignment(Pos.BOTTOM_LEFT);

        root.getChildren().add(top);
    }
}
