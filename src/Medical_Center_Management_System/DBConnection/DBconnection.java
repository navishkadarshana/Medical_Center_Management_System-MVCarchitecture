package Medical_Center_Management_System.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static DBconnection dBConnection;
    //------------------------------
    private Connection connection;
    private DBconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Medical_Center_Management_System",
                "root",
                "1519");
    }


    public static DBconnection GetInstance() throws ClassNotFoundException, SQLException{
        return (null==dBConnection)?(new DBconnection()):(dBConnection);
    }
    //------------------------------
    public Connection getConnection(){
        return connection;
    }
}
