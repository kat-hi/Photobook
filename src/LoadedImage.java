import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class LoadedImage {

    private String name;
    private double filesize;
    private File loadedFile;
    private ImageView loadedImageview;
    private Image image;
    private int col;
    private int row;
    private String title;
    private String fileName;

    private static DropShadow clickColor = new DropShadow();
    private static ImageView imageClicked;
    private static Boolean imageClickedChecker = Boolean.FALSE;


    public LoadedImage() {
    }

    public LoadedImage(File loadedFile) {
            this.loadedFile = loadedFile;
            this.fileName = loadedFile.getPath();
            this.name = loadedFile.getName();
            this.image = new Image("file:" + this.fileName, 500, 500, true, true, true);
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

    public ImageView getImageView() {
        return this.loadedImageview;
    }

    public String getName() {
        return this.name;
    }

    public void setRow(int row)  {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    private void handleMouseClicked() {
        if(imageClickedChecker) {
            imageClicked.setEffect(null);
        }
        this.loadedImageview.setEffect(clickColor);
        imageClickedChecker = Boolean.TRUE;
        imageClicked = this.loadedImageview;
        InfoBar.showDetails(this.fileName);
    }

    private void handleMouseDoubleClicked() {
        this.image = new Image("file:" + this.fileName, 600, 700, true, true, true);
        this.loadedImageview = new ImageView(this.image);
        this.loadedImageview.setFitWidth(-1);
        this.loadedImageview.setFitHeight(-1);
        this.loadedImageview.setPreserveRatio(true);
        Photoview.root.setCenter(this.loadedImageview);
    }

    /*

    private void selectImage(String filepath) {
        this.loadedImageview.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
            this.handleMouseClicked();
            this.loadedImageview.setEffect(clickColor);
            InfoBar.showDetails(this.loadedImageview.getId());
        });
        this.loadedImageview.addEventHandler(MouseEvent.MOUSE_EXITED, (event) -> {
            this.loadedImageview.setEffect(null);
        });

        //single click event to show dropshadow and Infobar
        this.loadedImageview.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
            //  System.out.println("imageClicked:" + imageClicked);
            //  System.out.println("imageview" + im);

            //imageClicked.setEffect(null);
            this.loadedImageview.setEffect(clickColor);
            //InfoBar.showDetails(this.loadedImageview.getId());
            //imageClicked = this.loadedImageview;


         if(!imageClicked.getId().equals(im.getId())) {
                System.out.println("test");
               imageClicked.setEffect(null);
               imageClicked = im;
               imageClicked.setEffect(clickColor);
         }

        });

        //double click even to show single image view
        this.loadedImageview.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2) {
                    Image img = new Image("file:" + filepath, 600, 700, true, true, true);
                    ImageView single = new ImageView(img);
                    single.setFitWidth(-1);
                    single.setFitHeight(-1);
                    single.setPreserveRatio(true);
                    Photoview.root.setCenter(single);
                }
            }
        });
    }

    */
}