
//Step 1 : SQL packages
import java.sql.*;

public class SelectDemo {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "Saloni@123";

        try {
            // Step 2 : Load Driver and register
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3 :Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Successfully Creates the connection");

            // Step 4: Prepared Statement
            String sql = "SELECT * FROM data";
            PreparedStatement ps = con.prepareStatement(sql);

            // Step 5: Execute Query

            ResultSet rs = ps.executeQuery();

            // Step 6 :Process the result
            while (rs.next()) {
                // Read data row by row
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");

                System.out.println(id + "|" + name +"|" + age + "|" + city +"|");
            }

            // Step 7 : Close the Connection

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
