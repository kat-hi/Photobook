import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FxFrontend extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Photobook!");
        stage.setResizable(true);

        BorderPane root = new BorderPane();
        root.setSpacing(5);
        root.setPadding(new Insets(5, 10 ,5, 10));

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Photobook");
        stage.setScene(scene);

        MenuTab menuTab = new MenuTab(root, BASELINE_CENTER);
        FilterTab filterTab = new FilterTab(root, BASELINE_CENTER);
        BrowserBar browserBar = new BrowserBar(root, BASELINE_LEFT);
        Photoview photoview = new Photoview(root, BASELINE_RIGHT);

        stage.show();
    }
}