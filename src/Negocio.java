
/**
    * @author Nils Muralles
    * @version 1.0
    * @since 20/10/2023
    * @modificationDate 23/10/2023
    * Clase controladora que meneja la lógica del programa
*/

import java.util.ArrayList;

public class Negocio {

    // Atributos de Negocio
    private ArrayList<Producto> productos;
    private Archivo inventario;

    // Constructor de Negocio
    public Negocio() {
        productos = new ArrayList<Producto>();
        inventario = new Archivo("inventario.CSV");
    }

    /**
     * Devuelve la lista de productos
     * 
     * @return ArrayList<Producto>
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Actualiza la lista de productos
     * 
     * @param productos
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Muestra todos los productos
     * 
     * @throws Exception
     */
    public void mostrarProductos() throws Exception {
        for (Producto producto : inventario.leer()) {
            System.out.println(producto.toString());
            System.out.println("");
        }
    }

    /**
     * Busca un producto por ID
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public Producto buscarProducto(int id) throws Exception {
        Producto productoBuscado = null;
        for (Producto producto : inventario.leer()) {
            if (producto.getId() == id) {
                productoBuscado = producto;
            }
        }
        return productoBuscado;
    }

    /**
     * Lista los productos de una categoría
     * 
     * @param categoria
     * @throws Exception
     */
    public void productosPorCategoria(String categoria) throws Exception {
        if (categoria.equals("Bebida") || categoria.equals("Helado") || categoria.equals("Snack")) {
            for (Producto producto : inventario.leer()) {
                if (producto.getCategoria().equals(categoria)) {
                    System.out.println("");
                    System.out.println(producto.toString());
                }
            }
        } else {
            System.out.println("No se encontró la categoría solicitada");
        }
    }

    /**
     * Muestra las ventas actuales
     * 
     * @throws Exception
     */
    public void ventasActuales() throws Exception {
        double ventasActuales = 0;
        double comision = 0;

        for (Producto producto : inventario.leer()) {
            ventasActuales += producto.getCantidadVendida() * producto.getPrecio();
            if (producto instanceof Helado) {
                comision += producto.getCantidadVendida() * producto.getPrecio();
            }
        }

        System.out.println("");
        System.out.println("El total vendido es: Q" + ventasActuales);
        System.out.println("La comisión corresponidente por la nueva categoría es: Q" + (comision * 0.20));
    }

    /**
     * Muestra el informe
     * 
     * @throws Exception
     */
    public void verInfore() throws Exception {
        String[] categorias = new String[3];
        categorias[0] = "Bebida";
        categorias[1] = "Helado";
        categorias[2] = "Snack";

        int bebidas = 0, helados = 0, snacks = 0;

        for (Producto producto : inventario.leer()) {
            if (producto instanceof Bebida) {
                bebidas++;
            } else if (producto instanceof Helado) {
                helados++;
            } else if (producto instanceof Snack) {
                snacks++;
            }
        }

        System.out.println("");
        System.out.println("---CONTEO POR CATEGORÍA---");
        System.out.println("Bebidas: " + bebidas);
        System.out.println("Helados: " + helados);
        System.out.println("Snacks: " + snacks);
        System.out.println("");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println("---" + categorias[i].toUpperCase() + "S---");
            productosPorCategoria(categorias[i]);
            System.out.println("");
        }

        ventasActuales();

    }

    /**
     * Actualiza el inventario
     * 
     * @throws Exception
     */
    public void guardarInventario() throws Exception {
        inventario.escribir(productos);
    }

}
