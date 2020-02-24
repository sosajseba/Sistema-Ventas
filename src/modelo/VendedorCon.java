package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sosaj
 */
public class VendedorCon implements Crud{
 
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validarUsuario(String dni,String user){
        
        String consulta = "select * from vendedor where dni=? and user=? ";
        Usuario u = new Usuario();
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
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
    
    @Override
    public List listar() {
        
        List<Vendedor> listaVendedor = new ArrayList<>();
        
        String consulta = "select * from vendedor";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Vendedor v = new Vendedor();
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setDni(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setUser(rs.getString(5));
                
                listaVendedor.add(v);
                
            }
            
        } catch (SQLException e) {
        }
        
        return listaVendedor;
        
    }
    
    public List listarBusqueda(String nombre) {
        
        List<Vendedor> listaVendedor = new ArrayList<>();
        
        String consulta = "select * from vendedor where nombres like '%"+nombre+"%'";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Vendedor v = new Vendedor();
                v.setId(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setDni(rs.getString(3));
                v.setTel(rs.getString(4));
                v.setUser(rs.getString(5));
                
                listaVendedor.add(v);
                
            }
            
        } catch (SQLException e) {
        }
        
        return listaVendedor;
        
    }

    @Override
    public int agregar(Object[] o) {
        int r = 0;
        
        String consulta = "insert into vendedor (nombres,dni,telefono,user) values(?,?,?,?)";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        
        return r;
        
    }

    @Override
    public int actualizar(Object[] o) {
        
        int r = 0;
        String consulta = "update vendedor set nombres = ?, dni = ?, telefono = ?, user = ? where idvendedor = ?" ;
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        
        return r;
        
    }

    @Override
    public void eliminar(int id) {
        
        String consulta = "delete from vendedor where id = ?";
        
        try {
            
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    
}
