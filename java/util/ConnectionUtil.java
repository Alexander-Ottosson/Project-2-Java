package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ConnectionUtil {
    private Connection conn;
    private static Logger Log = LogManager.getLogger("Util");

    public Connection createConnection() {

        try {
            String url = System.getenv("Project2_URL");
            String username = System.getenv("postgres");
            String password = System.getenv("Project2_PASSWORD");
            conn = DriverManager.getConnection(url, username, password);
            Log.info("Successfully retrieved connection to database.");
            return conn;

        } catch (SQLException e) {
            Log.warn("Threw SQL Exception while attempting to get connection: " + e);
            return null;
        }
    }
}
