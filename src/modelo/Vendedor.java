/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sosaj
 */
public class Vendedor {
    
    private int idvendedor;
    private String nombres;
    private String telefono;
    private String dni;
    private String user;

    public Vendedor() {
    }

    public Vendedor(int id, String nombres, String telefono, String dni, String user) {
        this.idvendedor = id;
        this.nombres = nombres;
        this.telefono = telefono;
        this.dni = dni;
        this.user = user;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
