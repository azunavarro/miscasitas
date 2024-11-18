package miscasitas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD{


    private static final String  host = "jdbc:mysql://localhost:3306/miscasitas";
    private static final String user = "babul";
    private static final String pass = "Tolentino2020";

     public static Connection getConnection() throws SQLException{
         return DriverManager.getConnection(host, user, pass);

     }


}













