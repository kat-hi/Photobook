import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.File;

public class Photoview extends GridPane {

    public Photoview () {
    }
    public Photoview(BorderPane root) {
        GridPane grid = new GridPane();
        root.getChildren().add(grid);
        root.setCenter(this);
    }

    public void addImage(int colIndex, int rowIndex, String filepath) {
        Image image = new Image("file:"+filepath, 200,200,true,true,true);
        this.add(new ImageView(image), colIndex, rowIndex);
    }

    // setFitWidth (buch.stage.getWidth
    public void addImages(File directoryPath) {
        File[] fileList = directoryPath.listFiles();
        if (fileList != null) {
            int colIndex = 0;
            int rowIndex = 0;

            for (File file : fileList) {
                System.out.println(file.getPath());
                Image image = new Image("file:"+file.getPath(), 200,200,true,true,true);
                this.add(new ImageView(image), colIndex, rowIndex);

                colIndex+=1;
                if(colIndex == 5) {
                    rowIndex+=1;
                    colIndex = 0;
                }
            }
        }
        System.out.println("Create Photoview");
    }
}
