
import java.sql.*;

public class Main {
    public static void main(String[] args) {

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
            System.out.println("<><><><><><><><><>><<><<><><>");

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
            System.out.println("<><><><><><><><><>><<><<><><>");
            // ===================== INSERT Using PreparedStatement=====================
            System.out.println("\n--- Insert New Employee Using PreparedStatement ---");
            String insertQueryPS = "INSERT INTO employees (id, name, job_title, salary) Values (?,?,?,?)";
            PreparedStatement psInsert = con.prepareStatement(insertQueryPS);
            psInsert.setInt(1, 5);
            psInsert.setString(2, "E");
            psInsert.setString(3, "ED");
            psInsert.setDouble(4, 150000.0);
            psInsert.executeUpdate();
            System.out.println("Employee inserted successfully");
            psInsert.close();
            System.out.println("<><><><><><><><><>><<><<><><>");
            // ===================== UPDATE =====================
            System.out.println("\n--- Update Employee Salary ---");
            String updateQuery = "UPDATE employees SET job_title = 'B-Dev', salary = 65000.0 WHERE id = 2";
            Statement stmtUpdate = con.createStatement();
            int rowsAffectedByUpdate = stmtUpdate.executeUpdate(updateQuery);
            System.out.println(rowsAffectedByUpdate);

            // ===================== UPDATE Using PreparedStatement=====================

            System.out.println("\n--- Update Employee Salary Using PreparedStatement---");
            String updateQueryPS = "UPDATE employees SET job_title = ?, salary = ? WHERE id = ?";
            PreparedStatement pstmtUpdate = con.prepareStatement(updateQueryPS);
            pstmtUpdate.setString(1, "B-Dev");
            pstmtUpdate.setDouble(2, 655000.0);
            pstmtUpdate.setInt(3, 2);
            pstmtUpdate.executeUpdate();
            System.out.println("<><><><><><><><><>><<><<><><>");

            // ===================== DELETE =====================
            System.out.println();
            System.out.println("\n--- Delete Employee ---");

            String deleteQuery = "DELETE FROM employees where id = 5;";
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
            System.out.println("<><><><><><><><><>><<><<><><>");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
