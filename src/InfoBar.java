import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * this class visualizes the right part of the photobook that shows information about a picture that is selected
 */
public class InfoBar extends VBox {
    private static Logger filelog = Logger.getLogger(InfoBar.class.getName());
    private static TextArea exifArea;
    private static TextArea menuArea;

    /**
     * This method is the default constructor.
     */
    public InfoBar() {

    }
    /**
     * this method provides a constructor with one parameter that defines where this object should be integrated.
     * @param root this is the javaFX object, where this layout-component should be integrated
     */
    public InfoBar(BorderPane root) {
        filelog.addHandler(FxFrontend.filehandler);
        this.setStyle(
                "-fx-min-width: 200px;" +
                "-fx-background-color: SLATEGREY;");
        exifArea = new TextArea("");
        exifArea.setFont(Font.font("Verdana", 12));
        exifArea.setVisible(true);
        exifArea.setStyle("-fx-bordercolor: white;");
        exifArea.setWrapText(true);
        exifArea.setEditable(false);
        exifArea.setMinHeight(600);
        exifArea.setMaxWidth(300);
        exifArea.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        filelog.info("Infobar created");

        menuArea = new TextArea("");
        menuArea.setFont(Font.font("Verdana", 13));
        menuArea.setEditable(false);
        menuArea.setMinHeight(30);
        menuArea.setMaxHeight(50);
        menuArea.setWrapText(true);
        menuArea.setMaxWidth(300);
        menuArea.setStyle(
                "-fx-padding: 10px; " +
                "-fx-border-insets: 10px; " +
                "-fx-background-insets: 20px 0 10px 0;");

        root.setRight(this);
        this.setPadding(new Insets(20,20,20,20));
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(exifArea);
        this.getChildren().add(menuArea);
    }

    /**
     * this method extracts metadata of a picture that is selected
     * @param filepath this parameter is used to create a new file object based on the current filepath that is given
     */
    public static void showExifDetails(String filepath) {
        File file = new File(filepath);
        Metadata metadata = null;
        try {
            metadata = ImageMetadataReader.readMetadata(file);
        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }

        if (metadata != null) {
            String tags = "";
            for (Directory directory : metadata.getDirectories()) {
                filelog.info("Directory: " + directory);
                for (Tag tag : directory.getTags()) {
                    filelog.info("Tag: " + tag);
                    System.out.println("EXIF Data: " + tag.toString());
                    tags = tag.toString() + "\n\r" + tags;
                }
                exifArea.setText(tags);
            }
        }
    }

    public static void showMenuSelection(String text){
        menuArea.setText(text);
    }
}