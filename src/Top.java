import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * This class visualizes the top of this frontend. First we wanted it to contain two rows: menu and filter.
 * Since we had time constraints, we decided to exclude the filter-row and only use the menu-row.
 */
public class Top extends VBox {
    private static Logger filelog = Logger.getLogger(Top.class.getName());

    public Top() {

    }

    /**
     * This method provides a constructor with two parameters
     * @param root this parameter adds this object to the javaFX-Component where it should be integrated
     * @param stage this parameter is needed to create a menuTab-object based on the right stage that is used.
     */
    public Top(BorderPane root, Stage stage){
        filelog.addHandler(FxFrontend.filehandler);

        VBox top = new VBox();
        root.setTop(this);

        MenuTab menu = new MenuTab(stage);
        //Filter filter = new Filter(top);
        this.getChildren().add(menu);
        this.setStyle("-fx-background-color : black");

        menu.setAlignment(Pos.TOP_CENTER);
        //filter.setAlignment(Pos.BOTTOM_CENTER);

        root.getChildren().add(top);
        filelog.info("Top created");
    }
}
