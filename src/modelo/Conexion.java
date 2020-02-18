package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sosaj
 */
public class Conexion {

    Connection cn;
    String url = "jdbc:mysql://localhost:3306/cerrajeria";
    String user = "root";
    String pass = "";
    public Connection conectar(){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(url,user,pass);
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return cn;
        
    }

    
}
