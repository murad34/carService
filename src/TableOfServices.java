
import java.sql.SQLException;
import java.sql.Statement;

public class TableOfServices {
    public void servicetable() {

        Statement statement;
        Connect_with_DB connectDB = new Connect_with_DB();

        try {
            String sql = "Create table TableOfServices"+
                    "(id serial primary key," +
                    "Washing varchar," +
                    "CleaningTheInside varchar," +
                    "ChangeOfOil varchar," +
                    "ChangeOfBrakes varchar," +
                    "ChangeOfMotor varchar," +
                    "ChangeOfWheels varchar," +
                    "ChangeOfCarcass varchar)";
            statement = connectDB.connecting().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Table created successfully");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
