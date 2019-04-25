import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection getConnection() {
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect_bd", "root", "");
        } catch (Exception e) {
            System.out.println("ERROR: Couldn't make the connection");
            e.printStackTrace();
        }
        return myConnection;
    }

}
