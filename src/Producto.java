
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 20/10/2023
 * @modificationDate 23/10/2023
 *                   Clase que modela un Producto
 */

public class Producto {

    // Atributos de Producto
    protected int id;
    protected String categoria;
    protected String nombre;
    protected int cantidadDisponible;
    protected int cantidadVendida;
    protected String estado;
    protected double precio;

    // Constructor de Producto
    public Producto(int id, String categoria, String nombre, int cantidadDisponible, int cantidadVendida, String estado,
            double precio) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendida = cantidadVendida;
        this.estado = estado;
        this.precio = precio;
    }

    // Setters y getters
    /**
     * Devuelve el ID
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Actualiza el ID
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve la categoría
     * 
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Actualiza la categoría
     * 
     * @param categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve el nombre
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuevle la cantidad disponible
     * 
     * @return
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Actualiza la cantidad disponible
     * 
     * @param cantidadDisponible
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Devuelve la cantidad vendida
     * 
     * @return
     */
    public int getCantidadVendida() {
        return cantidadVendida;
    }

    /**
     * Actualiza la cantidad vendida
     * 
     * @param cantidadVendida
     */
    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    /**
     * Devuelve el estado
     * 
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Actualiza el estado
     * 
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el precio
     * 
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Actualiza el precio
     * 
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la cadena que representa al Producto
     */
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible
                + ", cantidadVendida=" + cantidadVendida + ", estado=" + estado + ", precio=" + precio + "]";
    }

}
