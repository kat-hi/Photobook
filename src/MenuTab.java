import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import java.io.File;

public class MenuTab extends HBox {

    public MenuTab(BorderPane root, Pos pos) {
        root.getChildren().add(this);
        Button fileBtn = new Button("open File");
        Button directoryBtn = new Button("open Directory");
        root.getChildren().add(fileBtn);
        root.getChildren().add(directoryBtn);
        this.setAlignment(position);
    }
    private void openResourceFile () {
        fileBtn.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            String filepath = fileChooser.showOpenDialog(stage).getPath();
            System.out.println(filepath);
            if(!filepath.equals("")){
                Image image = new Image("file:"+filepath, 500, 500, true, true,true);
                photoview.add(new ImageView(image), 3,1);
            }
        });
    }

    private void openDirectory () {
        directoryBtn.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("load directory");
            File selectedDirectory = directoryChooser.showDialog(stage);
            File[] fileList = selectedDirectory.listFiles();
            if (fileList != null) {
                int colIndex = 0;
                int rowIndex = 0;

                for (File filepath : fileList) {
                    System.out.println(filepath);
                    Image image = new Image("file:"+filepath, 200,200,true,true,true);
                    photoview.add(new ImageView(image), colIndex, rowIndex);

                    colIndex+=1;
                    if(colIndex == 5) {
                        rowIndex+=1;
                        colIndex = 0;
                    }
                }
            }
        });
    }
}
