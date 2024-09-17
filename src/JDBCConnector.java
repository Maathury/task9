import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnector {
    public static void main(String[] args) throws SQLException {


        try {

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/task?user=root&password=password");

            //connection established between mysql and java through jdbc

            Statement stmt = connection.createStatement();

            stmt.execute("""
            Statement stmt = connection.createStatement();
            stmt.execute("""
                    create table task.empDetails (empcode int unique not null, empname varchar(50), empage int, salary int);
            """);
    //query 1
    stmt.execute("""
            //query 1
            stmt.execute("""
                insert into task.empDetails(empcode,empname,empage,salary) 
                values(101,"Jenny",25,10000),
                (102,"Jacky",30,20000),
                (103,"Joe",20,40000),
                (104,"John",40,80000),
                (105,"Shameer",25,90000);             
                """);

            //query 2

            ResultSet resultSet= stmt.executeQuery("select * from task.empDetails;");

            ResultSet resultSet= stmt.executeQuery("select * from task.empDetails;");
            while (resultSet.next()){
                //printing table
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)
                        +" "+resultSet.getInt(4)
                );
            }

            while (resultSet.next()){
                //printing table
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)
                        +" "+resultSet.getInt(4)
                );
                connection.close();
                stmt.close();
                resultSet.close();
            } catch (SQLException e) {
//            e.getStackTrace();
                System.out.println(e.getMessage());
            }

            connection.close();
            stmt.close();
            resultSet.close();


        }
    }
}

