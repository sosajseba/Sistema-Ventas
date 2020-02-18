package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sosaj
 */
public class VendedorCon {
 
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection cn;
    
    public Usuario validarUsuario(String dni,String user){
        
        String consulta = "select * from vendedor where dni=? and user=? ";
        Usuario u = new Usuario();
        
        try {
            
            cn = con.conectar();
            ps = (PreparedStatement) cn.prepareStatement(consulta);
            ps.setString(1, dni);
            ps.setString(2, user);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                u.setId(1);
                u.setDni(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setTelefono(rs.getString(4));
                u.setUsuario(rs.getString(5));
                
            }
            
        } catch (SQLException e) {
        }
        
        return u;
        
    }
           
    
}
