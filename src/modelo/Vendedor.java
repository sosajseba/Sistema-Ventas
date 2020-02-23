package modelo;

/**
 *
 * @author sosaj
 */
public class Vendedor {

    private int id;
    private String nombre;
    private String dni;
    private String tel;
    private String user;

    public Vendedor() {
    }

    public Vendedor(int id, String nombre, String dni, String tel, String user) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.tel = tel;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
