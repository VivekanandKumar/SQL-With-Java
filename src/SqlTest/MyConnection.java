package SqlTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection{

    public static Connection connectDb() {
        String url = "jdbc:mysql://localhost/vicky";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","3663");
            System.out.println("Connection created with Database successfully");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}