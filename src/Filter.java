import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class is not used. It is an artifact from the very beginning but it is still used by the layout we decided to implement.
 */
public class Filter extends HBox {

    public Filter(VBox root) {

        HBox filter = new HBox();
        this.setStyle("-fx-background-color : BLACK");

        Button button = new Button("Test");
        this.getChildren().add(button);

        System.out.println("Create Filter");
    }
}
