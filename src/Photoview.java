import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Photoview extends GridPane {

    private BorderPane borderPane;

    public Photoview(BorderPane root, Pos position) {
        root.getChildren().add(this);
        this.setAlignment(position);
    }


    public void add(ImageView imageView, int colIndex, int rowIndex) {

    }

}
