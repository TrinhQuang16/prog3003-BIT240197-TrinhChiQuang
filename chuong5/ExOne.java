import java.sql.*;
public class ExOne {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://DESKTOP-6CCNID2:1433;databaseName=JavaJDBC_DB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        String sql = "SELECT id, username, email FROM users";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("=====================================");
            System.out.println("=== DANH SÁCH NGƯỜI DÙNG ===");
            System.out.println("=====================================");
            System.out.printf("%-5s | %-20s | %-25s%n", "ID", "USERNAME", "EMAIL");
            System.out.println("-----------------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                
                System.out.printf("%-5d | %-20s | %-25s%n", id, username, email);
            }
            System.out.println("=====================================");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn!");
            e.printStackTrace();
        }
    }
}