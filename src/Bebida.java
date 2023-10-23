
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 20/10/2023
 * @modificationDate 23/10/2023
 *                   Clase que modela una Bebida, la cual hereda de Producto
 */

public class Bebida extends Producto {

    // Atributos de Bebida
    private double ml;
    private String tipo;

    // Constructor de Bebida
    public Bebida(int id, String categoria, String nombre, int cantidadDisponible, int cantidadVendida, String estado,
            double precio,
            double ml, String tipo) {
        super(id, categoria, nombre, cantidadDisponible, cantidadVendida, estado, precio);
        this.ml = ml;
        this.tipo = tipo;
    }

    // Setters y getters
    /**
     * Devuelve los mililitros de la bebida
     * 
     * @return
     */
    public double getMl() {
        return ml;
    }

    /**
     * Actualiza los mililitros de la bebida
     * 
     * @param ml
     */
    public void setMl(double ml) {
        this.ml = ml;
    }

    /**
     * Devuelve el tipo de bebida
     * 
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Actualiza el tipo de bebida
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Cadena que representa a una Bebida
     */
    @Override
    public String toString() {
        return "Id: " + id + "\nNombre: " + nombre + "\nCategoría: " + categoria + "\nEstado: " + estado
                + "\nCantidad Disponible: " + cantidadDisponible + "\nCantidad Vendida: " + cantidadVendida
                + "\nPrecio: Q" + precio + "\nMedida: " + ml + "ml \nTipo: " + tipo;
    }

}
