
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.*;


public class dbconn{
    private static String username="root";
    private static String pass="hazzaforever";
    private static String db="logindetails";
    private static String server="localhost";
    private static Integer portno=3306;
    public static Connection getConnection(){
      Connection con1=null;
      MysqlDataSource srcdata=new MysqlDataSource();
      srcdata.setUser(username);
      srcdata.setPassword(pass);
      srcdata.setDatabaseName(db);
      srcdata.setServerName(server);
      srcdata.setPortNumber(portno);
        try {
            con1=srcdata.getConnection();
        } 
         catch (SQLException e) {
            Logger.getLogger("Get connection "+dbconn.class.getName()).log(Level.SEVERE, null, e);
        }
    return con1;
    }
}
