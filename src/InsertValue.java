
import java.sql.Connection;
import java.sql.Statement;

public class InsertValue {

    public void insertvalue() {

        Statement statement;
        Connect_with_DB connectDB = new Connect_with_DB();

        try{
            String sql="insert into maintable(modelofcar,dateofreceiving,dateofgiving,servicecost) values("+")";
            statement=connectDB.connecting().createStatement();
            statement.executeUpdate(sql);
            //System.out.println("Values inserted successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
