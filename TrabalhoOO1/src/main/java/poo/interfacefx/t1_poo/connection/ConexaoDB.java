package poo.interfacefx.t1_poo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    //Class.forName("com.mysql.jdbc.Driver");
    private static final String url = "jdbc:mysql://localhost:3306/store_db?allowPublicKeyRetrieval=true&useSSL=false";
    public static final String user = "trabPOO";
    public static final String password = "password";
    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
