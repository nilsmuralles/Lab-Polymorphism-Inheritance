
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 20/10/2023
 * @modificationDate 23/10/2023
 *                   Clase que modela un Snack, la cual hereda de Producto
 */

public class Snack extends Producto {

    // Atributos de Snack
    private double gr;
    private String sabor;
    private String tamaño;

    // Constructor de Snack
    public Snack(int id, String categoria, String nombre, int cantidadDisponible, int cantidadVendida, String estado,
            double precio,
            double gr, String sabor, String tamaño) {
        super(id, categoria, nombre, cantidadDisponible, cantidadVendida, estado, precio);
        this.gr = gr;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    // Setters y getters
    /**
     * Devuelve los gramos
     * 
     * @return
     */
    public double getGr() {
        return gr;
    }

    /**
     * Actualiza los gramos
     * 
     * @param gr
     */
    public void setGr(double gr) {
        this.gr = gr;
    }

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
     * Cadena que representa al Snack
     */
    @Override
    public String toString() {
        return "Id: " + id + "\nNombre: " + nombre + "\nCategoría: " + categoria + "\nEstado: " + estado
                + "\nCantidad Disponible: " + cantidadDisponible + "\nCantidad Vendida: " + cantidadVendida
                + "\nPrecio: Q" + precio + "\nMedida: " + gr + "gr \nSabor: " + sabor + "\nTamaño: " + tamaño;
    }

}
