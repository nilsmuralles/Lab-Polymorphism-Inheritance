
/**
    * @author Nils Muralles
    * @version 1.0
    * @since 20/10/2023
    * @modificationDate 23/10/2023
    * Clase Archivo, la cual se encarga de manejar la persistencia de datos
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Archivo {

    // Atributos de Archivo
    private File archivo;

    // Constructor de Archivo
    /**
     * Constructor de Archivo
     * 
     * @param nombreArchivo
     */
    public Archivo(String nombreArchivo) {
        archivo = new File(nombreArchivo);
        archivo = new File(archivo.getAbsolutePath());
    }

    /**
     * Método que escribe sobre el CSV
     * 
     * @param productos
     * @throws Exception
     */
    public void escribir(ArrayList<Producto> productos) throws Exception {

        // Escritor
        PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));

        for (Producto producto : productos) { // Ciclo que agrega la información al CSV

            // Información general del producto
            String linea = producto.getId() + "," + producto.getCategoria() + "," + producto.getNombre() + ","
                    + producto.getCantidadDisponible() + ","
                    + producto.getCantidadVendida() + "," + producto.getEstado() + "," + producto.getPrecio();

            if (producto instanceof Bebida) { // Información de la bebida
                linea = linea + "," + ((Bebida) producto).getMl() + ",NA," + ((Bebida) producto).getTipo() + ",NA,NA";
                writer.println(linea);

            } else if (producto instanceof Helado) { // Información del helado
                linea = linea + ",NA,NA," + ((Helado) producto).getTipo() + "," + ((Helado) producto).getSabor() + ","
                        + ((Helado) producto).getTamaño();
                writer.println(linea);

            } else if (producto instanceof Snack) { // Información del snack
                linea = linea + ",NA," + ((Snack) producto).getGr() + ",NA," + ((Snack) producto).getSabor() + ","
                        + ((Snack) producto).getTamaño();
                writer.println(linea);
            }
        }

        writer.close();

    }

    /**
     * Método que lee el CSV
     * 
     * @return
     * @throws Exception
     */
    public ArrayList<Producto> leer() throws Exception {

        // Lista con todos los productos
        ArrayList<Producto> productos = new ArrayList<Producto>();

        // Lector
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String producto;
        while ((producto = br.readLine()) != null) {
            String[] datos = producto.split(",");

            if (datos[1].equals("Bebida")) {
                productos.add(new Bebida(Integer.parseInt(datos[0]), "Bebida", datos[2], Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]), datos[5], Double.parseDouble(datos[6]),
                        Double.parseDouble(datos[7]), datos[9]));
            }

            if (datos[1].equals("Helado")) {
                productos.add(new Helado(Integer.parseInt(datos[0]), "Helado", datos[2], Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]), datos[5], Double.parseDouble(datos[6]), datos[9], datos[10],
                        datos[11]));
            }

            if (datos[1].equals("Snack")) {
                productos.add(new Snack(Integer.parseInt(datos[0]), "Snack", datos[2], Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]), datos[5], Double.parseDouble(datos[6]),
                        Double.parseDouble(datos[8]),
                        datos[10], datos[11]));
            }
        }

        br.close();
        return productos;
    }

}
