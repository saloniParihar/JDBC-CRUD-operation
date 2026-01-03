import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateDemo {
    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Saloni@123";
        try {

            // Step 1 : Load and register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2 :Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection create Successfully");

            // Step 3 : Prepare statement
            String sql = "CREATE DATABASE student";
            PreparedStatement ps = con.prepareStatement(sql);

            // Step 4 : Execute query
            ps.executeUpdate();

            // Step 5 : process the result
            System.out.println("Database created Successfully");

            // Step 6 : close the connection to free resources
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}