import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.File;

public class FxFrontend extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World!");
        stage.setResizable(true);
        GridPane root = new GridPane();
        Button fileBtn = new Button("open File");
        Button directoryBtn = new Button("open Directory");

        root.add(fileBtn, 0, 0);
        root.add(directoryBtn, 0, 1 );
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setHgap(10);
        root.setVgap(10);

        fileBtn.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            String filepath = fileChooser.showOpenDialog(stage).getPath();
            System.out.println(filepath);
            if(!filepath.equals("")){
                Image image = new Image("file:"+filepath, 500, 500, true, true,true);
                root.add(new ImageView(image), 3,1);
            }
        });

        //directoryBtn.setOnAction(new EventHandler<ActionEvent>() {
        //    @Override
        //    public void handle(ActionEvent event) {

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
                    root.add(new ImageView(image), colIndex, rowIndex);

                    colIndex+=1;
                    if(colIndex == 5) {
                        rowIndex+=1;
                        colIndex = 0;
                    }
                }
            }
        });

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Photobook");
        stage.setScene(scene);

        stage.show();
    }
}