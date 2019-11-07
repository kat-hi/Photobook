import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class FilterTab extends HBox {

    public FilterTab(BorderPane root, Pos position) {
        root.getChildren().add(this);
        this.setAlignment(position);
    }
}
