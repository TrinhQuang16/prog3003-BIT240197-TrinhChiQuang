import java.sql.*;
import java.util.Scanner;
public class ExTwo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://DESKTOP-6CCNID2:1433;databaseName=JavaJDBC_DB;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID user cần xóa: ");
        int idCanXoa = scanner.nextInt();
        String checkSql = "SELECT COUNT(*) FROM users WHERE id = ?";
        String deleteSql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, idCanXoa);
                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                
                if (count == 0) {
                    System.out.println("Không tìm thấy user có id = " + idCanXoa + " để xóa");
                    return;
                }
            }
            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                deleteStmt.setInt(1, idCanXoa);
                int rowsDeleted = deleteStmt.executeUpdate();
                
                if (rowsDeleted > 0) {
                    System.out.println("Đã xóa thành công user có id = " + idCanXoa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối hoặc truy vấn!");
            e.printStackTrace();
        }
        scanner.close();
    }
}