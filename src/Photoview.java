import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.File;
import java.util.logging.Logger;

import java.util.*;

public class Photoview extends TilePane {
    private static DropShadow clickColor = new DropShadow();
    private static ImageView imageClicked = null;
    public static BorderPane root;
    public static ArrayList<LoadedImage> currentImages;
    private static Logger filelog = Logger.getLogger("Photoview");

    public Photoview() {

    }

    public Photoview(BorderPane root) {
        currentImages = new ArrayList<LoadedImage>();
        filelog.addHandler(FxFrontend.handler);
        this.setVgap(10);
        this.setHgap(10);
        //root.setCenter(this);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30,0,20,0));
        ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120, 120);
        s1.setContent(this);
        s1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        s1.setFitToWidth(true);
        root.setCenter(s1);
        root.setStyle("-fx-background-color: GRAY");
    }

    public void addImages(List<File> files) {

        int colIndex = 0;
        int rowIndex = 0;
        for(File file : files) {
            LoadedImage lm = new LoadedImage(file);
            lm.setCol(colIndex);
            lm.setRow(rowIndex);
            ImageView im = lm.getImageView();
            this.getChildren().add(im);
            currentImages.add(lm);

            colIndex += 1;
            if (colIndex == 4) {
                rowIndex += 1;
                colIndex = 0;
            }
        }
        Browser.showLoadedFiles();
    }
}