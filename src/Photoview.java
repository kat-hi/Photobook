import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class visualizes the photoview in the center of the application. Fotos loaded from your browser will be shown in a grid.
 * A scrollbar can be used if there are more pictures than your screen can show at once.
 */
public class Photoview extends TilePane {
    private static Logger filelog = Logger.getLogger(Photoview.class.getName());
    public static ArrayList<LoadedImage> currentImages;

    /**
     * Default constructor to instantiate a photoview object
     */
    public Photoview() {
    }

    /**
     * photoview constructor with one necessary parameter.
     * @param root object that should contain this photoview
     */
    public Photoview(BorderPane root) {
        currentImages = new ArrayList<>();
        filelog.addHandler(FxFrontend.filehandler);
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30,0,30,0));

        ScrollPane s1 = new ScrollPane();
        s1.setPrefSize(120, 120);
        s1.setContent(this);
        s1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        s1.setFitToWidth(true);
        root.setCenter(s1);

        filelog.info("Photoview created");
    }

    /**
     * This method loades selected images into a grid in this photoview.
     * It is used by MenuTab-class when either fileChooser or directoryChooser is called
     * @param files list of Files that should be loaded into the grid. Even if only one picture is selected you have to use this method with a list object 
     */
    public void addImages(List<File> files) {
        for(File file : files) {
            LoadedImage li = new LoadedImage(file);
            ImageView iv = li.getImageView();
            this.getChildren().add(iv);
            currentImages.add(li);
        }
        Browser.showLoadedFiles();
        filelog.info("Images added");
    }
}