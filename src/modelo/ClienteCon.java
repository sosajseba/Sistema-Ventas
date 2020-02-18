/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sosaj
 */
public class ClienteCon implements Crud{
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        
        List<Cliente> listaClientes = new ArrayList<>();
        
        String consulta = "select * from cliente";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                
                listaClientes.add(c);
                
            }
            
        } catch (SQLException e) {
        }
        
        return listaClientes;
        
    }
    
    public List listarBusqueda(String dni) {
        
        List<Cliente> listaClientes = new ArrayList<>();
        
        String consulta = "select * from cliente where dni like '"+dni+"'";
        
        try {
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombres(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                
                listaClientes.add(c);
                
            }
            
        } catch (SQLException e) {
        }
        
        return listaClientes;
        
    }

    @Override
    public int agregar(Object[] o) {
        int r = 0;
        String consulta = "insert into cliente (nombre,dni,direccion,telefono) values(?,?,?,?)";
        
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
        String consulta = "update cliente set nombre = ?, dni = ?, direccion = ?, telefono = ? where idcliente = ?" ;
        
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
        
        String consulta = "delete from cliente where idcliente = ?";
        
        try {
            
            
            con = cn.conectar();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
    
}
