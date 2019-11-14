import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Browser extends VBox {

    public Browser(BorderPane root) {
        root.setLeft(this);
        this.setStyle("-fx-background-color : blue");
        Button button = new Button("Test");
        this.getChildren().add(button);

        System.out.println("Create Browser");
    }
}
