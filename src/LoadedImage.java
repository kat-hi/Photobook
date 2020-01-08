import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.File;

/**
 * This class is great. It simplifies the whole file handling and photo loading by collecting all necessary attributes of a file.
 * It provides the name of a foto, its File object, its imageView object, its image object and its position in the photoview grid given by row and column
 */
public class LoadedImage {

    private String name;
    private File loadedFile;
    private ImageView loadedImageview;
    private Image image;
    private String filepath;
    public static ImageView currentImage;

    private static DropShadow clickColor = new DropShadow();
    private static ImageView imageClicked;
    private static Boolean imageClickedChecker = Boolean.FALSE;

    /**
     * default constructor of loadedImage class
     */
    public LoadedImage() {
    }

    /**
     * Constructor of loadedImage class with a file parameter. Every loadedImage gets two eventlistener that listens on one-clickEvents or double-clickEvents
     * @param loadedFile this file object will be provided by the fileChooser or DirectoryChoose in MenuTab.class
     */
    public LoadedImage(File loadedFile) {
            this.loadedFile = loadedFile;
            this.filepath = loadedFile.getPath();
            this.name = loadedFile.getName();
            this.image = new Image("file:" + this.filepath, 200, 200, true, true, true);
            this.loadedImageview = new ImageView(image);
            this.loadedImageview.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
                this.handleMouseClicked();
            });
            this.loadedImageview.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        this.handleMouseDoubleClicked();
                    }
                }
            });
    }

    /**
     * @return returns the ImageView of the object on which the getter-method is called
     */
    public ImageView getImageView() {
        return this.loadedImageview;
    }

    /**
     * @return returns the name of the object on which the getter-method is called
     */
    public String getName() {
        return this.name;
    }

    /**
     * this method is called when the eventlistener detects an one-clickEvent. If there is an imagesClicked its
     * effect is set to null and the new image gets a bordershadow that marks its selection.
     */

    private void handleMouseClicked() {
        if(imageClickedChecker) {
            imageClicked.setEffect(null);
        }
        this.loadedImageview.setEffect(clickColor);
        imageClickedChecker = Boolean.TRUE;
        imageClicked = this.loadedImageview;
        InfoBar.showExifDetails(this.filepath);
    }

    /**
     * this method is called when the eventlistener detects a double-clickEvent.
     */
    private void handleMouseDoubleClicked() {
        this.image = new Image("file:" + this.filepath, 600, 600,
                true, true, true);
        this.loadedImageview = new ImageView(this.image);
        this.loadedImageview.setFitWidth(-1);
        this.loadedImageview.setFitHeight(-1);
        this.loadedImageview.setPreserveRatio(true);
        currentImage = this.loadedImageview;
        FxFrontend.root.setCenter(this.loadedImageview);
    }
}