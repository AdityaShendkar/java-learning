
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Tut";
        String user = " ";
        String password = " ";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Database");

            // ===================== READ =====================
            System.out.println("\n--- Existing Employees (READ) ---");

            String selectQuery = "SELECT * from employees;"; // READ Operation
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("============");
                System.out.println("id:- " + id + ", " + "name:- " + name + ", " + "Job-Title:- " + job_title + ", "
                        + "Salary:- " + salary);
            }
            rs.close();
            stmt.close();

            System.out.println();
            System.out.println("Connection closed successfully");

            // ===================== INSERT =====================
            System.out.println("\n--- Insert New Employee Using Statement ---");

            String insertQuery = "INSERT into employees(id, name, job_title, salary) VALUES(4,'D','DD',85000.0)";
            Statement stmtInsert = con.createStatement();
            int rowAffected = stmtInsert.executeUpdate(insertQuery);
            // System.out.println(rowAffected);
            if (rowAffected > 0) {
                System.out.println("Insert successfull =" + rowAffected + " row affected");
            } else {
                System.out.println("Insertion failed");
            }
            stmtInsert.close();
            System.out.println();
            System.out.println("Connection closed successfully");

            // ===================== INSERT =====================
            System.out.println("\n--- Insert New Employee Using PreparedStatement ---");

            // ===================== DELETE =====================
            System.out.println();
            System.out.println("\n--- Delete Employee ---");

            String deleteQuery = "DELETE FROM employees where id = 4;";
            Statement stmtDelete = con.createStatement();
            int rowsAffectedByDelete = stmtDelete.executeUpdate(deleteQuery);
            System.out.println(rowsAffectedByDelete);
            if (rowsAffectedByDelete > 0) {
                System.out.println("Deletion successfull =" + rowsAffectedByDelete + " row affected");
            } else {
                System.out.println("Deletion failed");
            }
            stmtDelete.close();
            System.out.println();
            System.out.println("Connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}