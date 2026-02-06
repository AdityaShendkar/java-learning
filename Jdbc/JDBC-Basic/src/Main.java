
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Tut";
        String user = " ";
        String password = " ";



        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try(Connection con = DriverManager.getConnection(url,user, password)){
            System.out.println("Connected to Database");


            // ===================== READ =====================
            System.out.println("\n--- Existing Employees (READ) ---");

            String selectQuery = "SELECT * from employees;"; //READ Operation
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("============");
                System.out.println("id:- " + id+", "+"name:- "+name+", "+ "Job-Title:- "+job_title+", "+"Salary:- "+ salary);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully");


            // ===================== INSERT =====================
            System.out.println("\n--- Insert New Employee ---");




        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}