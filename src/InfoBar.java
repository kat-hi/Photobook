import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class InfoBar extends VBox {

    public InfoBar(BorderPane root){

        root.setRight(this);
        this.setStyle("-fx-background-color : black");
        Button button = new Button("Test");
        this.getChildren().add(button);

        System.out.println("Create InfoBar");
    }
}
