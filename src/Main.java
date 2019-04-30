import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tb_admin", "postgres", "sokha");
            connection.setAutoCommit(false);
            String queryStr = "INSERT INTO tb_admin VALUES(255,'Sokha','password')";
//            String queryStr = "SELECT * FROM tb_admin WHERE username like '%' ||?||'%'";
            PreparedStatement pstmt = connection.prepareStatement(queryStr);
            pstmt.executeUpdate();
//            connection.commit();
//            pstmt.setString(1, "sokh");
//            CallableStatement callableStatement = connection.prepareCall("{call getAdmin(?)}");
//            callableStatement.setInt(1, 1);
//            ResultSet resultSet = callableStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
//            }
            System.out.println("Connection successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
