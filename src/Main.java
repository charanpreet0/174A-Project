import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import Controller.*;

public class Main {
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:Users/karanveer/Desktop/School/Spring_21/CS174A/174A-Project/sqlite/db" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println( "Exception block error.");
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        createNewDatabase("Project1.db");
        CreateAndInitTable Table1 = new CreateAndInitTable();
        Table1.createNewTable();
    }
}