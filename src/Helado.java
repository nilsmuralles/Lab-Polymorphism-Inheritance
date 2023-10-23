
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 20/10/2023
 * @modificationDate 23/10/2023
 *                   Clase que modela una Helado, la cual hereda de Producto
 */

public class Helado extends Producto {

    // Atributos de Helado
    private String sabor;
    private String tipo;
    private String tamaño;

    // Constructor de Helado
    public Helado(int id, String categoria, String nombre, int cantidadDisponible, int cantidadVendida, String estado,
            double precio,
            String sabor, String tipo, String tamaño) {
        super(id, categoria, nombre, cantidadDisponible, cantidadVendida, estado, precio);
        this.sabor = sabor;
        this.tipo = tipo;
        this.tamaño = tamaño;
    }

    // Setters y getters
    /**
     * Devuelve el sabor
     * 
     * @return
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Actualiza el sabor
     * 
     * @param sabor
     */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    /**
     * Devuelve el tipo
     * 
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Actualiza el tipo
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el tamaño
     * 
     * @return
     */
    public String getTamaño() {
        return tamaño;
    }

    /**
     * Actualiza el tamaño
     * 
     * @param tamaño
     */
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Cadena que representa un Helado
     */
    @Override
    public String toString() {
        return "Id: " + id + "\nNombre: " + nombre + "\nCategoría: " + categoria + "\nEstado: " + estado
                + "\nCantidad Disponible: " + cantidadDisponible + "\nCantidad Vendida: " + cantidadVendida
                + "\nPrecio: Q" + precio + "\nSabor: " + sabor + "\nTipo: " + tipo + "\nTamaño: " + tamaño;
    }

}
