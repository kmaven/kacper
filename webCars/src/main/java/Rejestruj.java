import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rejestruj extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newLogin=request.getParameter("newLogin");
        String newPass=request.getParameter("newPass");

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Connect.conn = Connect.getConnection();
            stmt= Connect.conn.prepareStatement("insert into uzytkownicy(login,pass) values ('"+newLogin+"','"+newPass+"')");
            rs = stmt.executeQuery();
            response.sendRedirect("index.jsp");

            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            Connect.conn.close(); // Return to connection pool
            Connect.conn = null;  // Make sure we don't close it twice
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { ; }
                stmt = null;
            }
            if (Connect.conn != null) {
                try { Connect.conn.close(); } catch (SQLException e) { ; }
                Connect.conn = null;
            }
        }
    }
}
