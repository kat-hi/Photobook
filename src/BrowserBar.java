import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BrowserBar extends VBox {

    public BrowserBar(BorderPane root, Pos position) {
        root.getChildren().add(this);
        this.setAlignment(position);
    }
}
