import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

import java.io.IOException;

public class FxFrontend extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World!");

        GridPane root = new GridPane();
        Button openBtn = new Button("open File");

        root.add(openBtn, 0, 0);

        openBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                String filepath = fileChooser.showOpenDialog(stage).getPath();
                System.out.println(filepath);
                if(!filepath.equals("")){
                    Image image = new Image("file:"+filepath, 700, 800, true, true,true);
                    root.add(new ImageView(image), 3,1);
                }
            }
        });

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Photobook");
        stage.setScene(scene);

        stage.show();
    }
}