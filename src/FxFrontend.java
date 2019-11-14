import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FxFrontend extends Application {
    public static Photoview photoview;
   // public static MenuTab menu;
  //  public static Filter filter;
    public static Browser browser;
    public static InfoBar info;
    public static Top top;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Photobook!");
        stage.setMaximized(true);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color : #ffaadd");
        // root.setSpacing(5);
        // root.getChildren().setPadding(new Insets(5, 10 ,5, 10));

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Photobook");
        stage.setScene(scene);

        //menu = new MenuTab(root, stage);
        //filter = new Filter(root);
        browser = new Browser(root);
        info = new InfoBar(root);
        photoview = new Photoview(root);
        top = new Top(root, stage);

        stage.show();
    }
}