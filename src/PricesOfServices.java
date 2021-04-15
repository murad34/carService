
import java.sql.SQLException;
import java.sql.Statement;

public class PricesOfServices {
    public void pricesofservices() {

        Statement statement;
        Connect_with_DB connectDB = new Connect_with_DB();

        try {
            String sql = "Create table PricesOfServices"+
                    "(id serial primary key," +
                    "Services varchar," +
                    "Price integer)";
                    statement = connectDB.connecting().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
