package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnectoryFactory {
    public class DBConnectorFactory {
        private static Connection dbConn = null;

        public static Connection getDatabaseConnection() {
            if (dbConn != null) {
                return dbConn;
            }
            if (dbConn == null) {
                String url = "jdbc:mysql://localhost:3306/";
                try {
                    dbConn = DriverManager.getConnection(url, "root", "");
                    if (dbConn != null) {
                        JOptionPane.showMessageDialog(null, "Connected to local server", "H & AY Connection Status",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
            return dbConn;
        }
    }
}
