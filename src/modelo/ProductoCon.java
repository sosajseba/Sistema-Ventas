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
public class ProductoCon implements Crud{

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        
        List<Producto> listaProductos = new ArrayList<>();
        
        String consulta = "select * from producto";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setPrecio(rs.getDouble(2));
                p.setStock(rs.getInt(3));
                p.setDescripcion(rs.getString(4));
                
                listaProductos.add(p);
                
            }
            
        } catch (SQLException e) {
        }
        
        return listaProductos;
        
    }
    
    public List listarBusqueda(String descripcion) {
        
        List<Producto> listaProductos = new ArrayList<>();
        
        String consulta = "select * from producto where descripcion like '%"+descripcion+"%'";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setPrecio(rs.getDouble(2));
                p.setStock(rs.getInt(3));
                p.setDescripcion(rs.getString(4));
                
                listaProductos.add(p);
                
            }
            
        } catch (SQLException e) {
        }
        
        return listaProductos;
        
    }

    @Override
    public int agregar(Object[] o) {
        int r = 0;
        String consulta = "insert into producto (precio,stock,descripcion,estado) values(?,?,?,?)";
        
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
        String consulta = "update producto set precio = ?, stock = ?, descripcion = ? where idproducto = ?" ;
        
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
    public void eliminar(int id) {
        
        String consulta = "delete from producto where idproducto = ?";
        
        try {
            
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    
}
