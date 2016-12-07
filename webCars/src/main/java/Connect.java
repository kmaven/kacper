import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import javax.sql.DataSource;

public class Connect {

    public static Connection conn=null;


    public static Connection getConnection() throws Exception {

        Context ctx0 = new InitialContext();
        Context ctx1 = (Context)ctx0.lookup( "java:/comp/env" );
        DataSource ds = (DataSource)ctx1.lookup( "jdbc/samochody" );
        conn = ds.getConnection();
        System.out.println("Connected !");
        return conn;
    }
}
