import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InfoBar extends HBox {

    private Stage stage;

    public InfoBar(BorderPane root, Pos position){
        root.getChildren().add(this);
        this.setAlignment(position);
    }
}
