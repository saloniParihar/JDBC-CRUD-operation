
//Step 1 :Import java.ulit packages and SQL packages
import java.sql.*;
import java.util.Scanner;

public class InsertDemo {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "Saloni@123";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the id of the student:");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student:");
        String name = sc.next();
        System.out.println("Enter the age of the Student:");
        int age = sc.nextInt();
        System.out.println("Enter the city of the student:");
        String city = sc.next();

        try {
            // Step 2 : Load Driver and register
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3 :Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Successfully Creates the connection");

            // Step 4: Prepared Statement
            String sql = "INSERT INTO data VALUES (?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, city);

            // Step 5: Execute Query

            int i = ps.executeUpdate();

            // Step 6 :Process the result

            if (i > 0) {
                System.out.println("Record Inserted Successfully");

            } else {
                System.out.println(" insertion Fail");
            }
            // Step 7 : Close the Connection

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();

    }

}
