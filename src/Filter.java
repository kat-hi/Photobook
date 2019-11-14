import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class Filter extends HBox {

    public Filter(VBox root) {

        HBox filter = new HBox();
        //root.setAlignment(Pos.BOTTOM_CENTER);
        this.setStyle("-fx-background-color : red");

        Button button = new Button("Test");
        this.getChildren().add(button);

        System.out.println("Create Filter");
    }
}
