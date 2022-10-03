package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    
    static String bd = "estetica";
    static String port = "3307";
    static String login = "root";
    static String password = "admin";
    
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + DBConnection.port + "/" + DBConnection.bd;
            connection = DriverManager.getConnection(url,DBConnection.login,DBConnection.password);
            System.out.println("Conexion establecida");
        }catch (Exception e){
            System.out.println("Error de conexion");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
}
