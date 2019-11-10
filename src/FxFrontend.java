import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FxFrontend extends Application {
    public static Photoview photoview;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Photobook!");
        stage.setMaximized(true);
        BorderPane root = new BorderPane();
        // root.setSpacing(5);
        // root.getChildren().setPadding(new Insets(5, 10 ,5, 10));

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Photobook");
        stage.setScene(scene);

        MenuTab menuTab = new MenuTab(root, stage);
        // FilterTab filterTab = new FilterTab(root);
        // BrowserBar browserBar = new BrowserBar(root);
        photoview = new Photoview(root);
        stage.show();
    }
}