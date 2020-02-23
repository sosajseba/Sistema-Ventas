package modelo;

/**
 *
 * @author sosaj
 */
public class Producto {

    private int id;
    private double precio;
    private int stock;
    private String descripcion;
    private String estado;

    public Producto() {
    }

    public Producto(int id, double precio, int stock, String descripcion, String estado) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
