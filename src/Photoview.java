import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class Photoview extends GridPane {
    private static final Set<String> EXTENSIONS = new HashSet<>(Arrays.asList("jpg", "png"));
    private static DropShadow clickColor = new DropShadow();
    private static List<File> filelist;
    private static Logger filelog = Logger.getLogger("Photoview");

    public Photoview () {
    }

    public Photoview(BorderPane root) {
        filelog.addHandler((FxFrontend.handler));

        GridPane grid = new GridPane();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        this.setVgap(10);
        this.setHgap(10);
        root.setCenter(this);
        this.setAlignment(Pos.CENTER);
        root.getChildren().addAll(grid);
    }

    public void addImages(List<File> files) {
        filelist = new ArrayList<>(files);
        //String[] splittedFileName;

        int colIndex = 0;
        int rowIndex = 0;
        for(File file : filelist) {
            String filepath = file.getPath();
            Image image = new Image("file:" + filepath, 250, 200, false, true, true);
            ImageView imageview = new ImageView(image);
            selectImage(imageview);
            //imageview.setId(image.getPath()); // later
            // splittedFileName = filename.split(".");
            // if(EXTENSIONS.contains(splittedFileName[0])) {
            this.add(imageview, colIndex, rowIndex);

            colIndex += 1;
            if (colIndex == 4) {
                rowIndex += 1;
                colIndex = 0;
            }
        }
    }

    private void selectImage(ImageView imageview) {
        imageview.addEventHandler(MouseEvent.MOUSE_MOVED, (event) -> imageview.setEffect(clickColor));
        imageview.addEventHandler(MouseEvent.MOUSE_EXITED, (event) -> imageview.setEffect(null));
    }
}
