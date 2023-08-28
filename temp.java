import java.sql.*;
import java.util.Scanner;
class JDBCExample {
  public static void main(String[] args) {
    String DB_URL = "jdbc:mysql://localhost:3306/hostel";
    String USER = "root";
    String PASS = "";

    // Scanner ob = new Scanner(System.in);
    // System.out.print("Enter Code: ");
    // int roll = ob.nextInt();
    // System.out.print("Enter Name: ");
    // String name = ob.next();
    try {
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      Statement stmt = conn.createStatement();
       String sql = "Insert into stu(roll, name) values(101, 'xyz')";
      //String sql = "create table stu(roll int,name varchar(20)) ";
      stmt.executeUpdate(sql);
      System.out.println("Record inserted successfully...");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}