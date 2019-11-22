import javafx.scene.layout.BorderPane;

import java.nio.file.FileSystems;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.nio.file.Paths;
// https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

// @TODO using maven for implementing jdbc-sqlite driver

public class DBController {

    private static Logger filelog = Logger.getLogger("Browser");


    public static void connect() {
        filelog.addHandler((FxFrontend.handler));
        filelog.info("connecting to database...");
        System.out.println("Test");
        String relativePath = FileSystems.getDefault().getPath("photo.db").toString();
        System.out.println("RelativePath: " + relativePath);
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + relativePath;
            conn = DriverManager.getConnection(url);
            filelog.info("Connection to SQLite has been established.");
        } catch (SQLException e) {
            filelog.info(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                filelog.info(ex.getMessage());
            }
        }
    }
}

