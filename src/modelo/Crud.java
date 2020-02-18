package modelo;

import java.util.List;

/**
 *
 * @author sosaj
 */
public interface Crud {
    
    public List listar();
    public int agregar(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
    
}
