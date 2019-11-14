import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Top extends VBox {

    public Top(BorderPane root, Stage stage){
        System.out.println("Create TopBar");

        VBox top = new VBox();
        root.setTop(this);

        MenuTab menu = new MenuTab(top, stage);
        Filter filter = new Filter(top);
        this.getChildren().addAll(menu, filter);
        this.setStyle("-fx-background-color : green");
        //this.getChildren().add(this);

        menu.setAlignment(Pos.TOP_CENTER);
        filter.setAlignment(Pos.BOTTOM_CENTER);

        root.getChildren().add(top);
    }
}