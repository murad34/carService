
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_with_DB {

    public Connection connecting() {

        String url = "jdbc:postgresql://localhost:5432/carservice";
        String user = "postgres";
        String password = "murdikmurdik20032003";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;

    }
}
