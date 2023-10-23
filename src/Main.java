
/**
    * @author Nils Muralles
    * @version 1.0
    * @since 20/10/2023
    * @modificationDate 23/10/2023
    * Clase vista que contiene el menú principal del programa
*/

import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Negocio negocio = new Negocio();

        boolean seguir = true;
        while (seguir) { // Menú principal del prgorama
            System.out.println("");
            System.out.println("---BIENVENIDO---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Listar por categoría");
            System.out.println("5. Ventas actuales");
            System.out.println("6. Ver informe");
            System.out.println("7. Salir");
            System.out.print("¿Qué desea hacer? ");
            String opcion = input.nextLine();

            try { // Validar el input del usuario
                int op = Integer.parseInt(opcion);

                switch (op) {
                    case 1: // Agregar a un Producto
                        System.out.println("");
                        System.out.println("---AGREGAR PRODUCTO---");

                        System.out.print("Id del producto: ");
                        String idProducto = input.nextLine();

                        System.out.print("Nombre del producto: ");
                        String nombre = input.nextLine();

                        System.out.print("Cantidad disponible: ");
                        String cantidadDisponible = input.nextLine().toLowerCase();

                        System.out.print("Cantidad vendida: ");
                        String cantidadVendida = input.nextLine();

                        System.out.print("Indique el precio del producto: ");
                        String precioProducto = input.nextLine();

                        System.out.println("");
                        System.out.println("---CATEGORÍAS ACTUALES---");
                        System.out.println("1. Bebida");
                        System.out.println("2. Helado");
                        System.out.println("3. Snack");
                        System.out.print("¿A qué categoría pertenece? ");
                        String categoria = input.nextLine();
                        System.out.println("");

                        try { // Validar el ingreso de datos
                            int cat = Integer.parseInt(categoria);
                            int id = Integer.parseInt(idProducto);
                            int disponibles = Integer.parseInt(cantidadDisponible);
                            int vendidos = Integer.parseInt(cantidadVendida);
                            double precio = Double.parseDouble(precioProducto);

                            String estado = null; // Determinar el estado del producto
                            if (disponibles != 0) {
                                estado = "Disponible";

                            } else {
                                estado = "No disponible";
                            }

                            if (cat > 0 && cat < 4) { // Validar la categoría del producto

                                switch (cat) {
                                    case 1: // Bebida
                                        System.out.print("¿De cuántos mililítros es la bebida? ");
                                        String mililitros = input.nextLine();

                                        System.out.print(
                                                "¿Qué tipo de bebida? ");
                                        String tipo = input.nextLine();

                                        try {
                                            double ml = Double.parseDouble(mililitros);

                                            Bebida nuevaBebida = new Bebida(id, "Bebida", nombre, disponibles, vendidos,
                                                    estado, precio, ml, tipo);
                                            System.out.println("¡Bebida agregada exitosamente!");
                                            negocio.getProductos().add(nuevaBebida);

                                        } catch (Exception InputMismatchException) {
                                            System.out.println("Error al ingresar los datos de la bebida");
                                        }
                                        break;

                                    case 2: // Helado
                                        System.out.print("¿De qué sabor es el helado? ");
                                        String saborHelado = input.nextLine();

                                        System.out.print("¿De qué tipo es el helado? ");
                                        String tipoHelado = input.nextLine();

                                        System.out.print("¿De qué tamaño es el helado? ");
                                        String tamañoHelado = input.nextLine();

                                        Helado nuevoHelado = new Helado(id, "Helado", nombre, disponibles, vendidos,
                                                estado,
                                                precio, saborHelado, tipoHelado, tamañoHelado);
                                        System.out.println("¡Helado agregado exitosamente!");
                                        negocio.getProductos().add(nuevoHelado);
                                        break;

                                    case 3: // Snack
                                        System.out.print("¿De cuántos gramos es el snack? ");
                                        String gramos = input.nextLine();

                                        System.out.print("¿De qué sabor es el snack? ");
                                        String saborSnack = input.nextLine();

                                        System.out.print("¿De qué tamaño es el snack? ");
                                        String tamañoSnack = input.nextLine();

                                        try {
                                            double gr = Double.parseDouble(gramos);

                                            Snack nuevoSnack = new Snack(id, "Snack", nombre, disponibles, vendidos,
                                                    estado,
                                                    precio, gr, saborSnack, tamañoSnack);
                                            System.out.println("¡Sncak agregado exitosamente!");
                                            negocio.getProductos().add(nuevoSnack);

                                        } catch (Exception InputMismatchException) {
                                            System.out.println("Error al ingresar los datos del snack");
                                        }
                                        break;
                                }

                            } else {
                                System.out.println("Seleccione una categoría válida");
                            }

                        } catch (Exception NumberFormatExcpetion) {
                            System.out.println("Error al ingresar datos. Vuélvalo a intengar");
                        }

                        break;

                    case 2: // Mostrar productos
                        System.out.println("");
                        System.out.println("---TODOS LOS PRODUCTOS---");
                        negocio.mostrarProductos();
                        break;

                    case 3: // Buscar un producto por ID
                        System.out.println("");
                        System.out.print("Ingrese el Id del producto: ");
                        String idBuscando = input.nextLine();

                        try {
                            int id = Integer.parseInt(idBuscando);

                            if (negocio.buscarProducto(id) != null) {
                                System.out.println("");
                                System.out.println(negocio.buscarProducto(id).toString());

                            } else {
                                System.out.println("El producto no ha sido encontrado en el inventario");
                            }

                        } catch (Exception e) {
                            System.out.println("El ID debe ser un número");
                        }
                        break;

                    case 4: // Productos de una categoría
                        System.out.println("");
                        System.out.print("¿Qué categoría desea enlistar? ");
                        String categoriaBuscada = input.nextLine();
                        negocio.productosPorCategoria(categoriaBuscada);
                        break;

                    case 5: // Ventas actuales
                        System.out.println("");
                        System.out.println("---VENTAS ACTUALES---");
                        negocio.ventasActuales();
                        break;

                    case 6: // Informe completo
                        negocio.verInfore();
                        break;

                    case 7: // Salir
                        negocio.guardarInventario();
                        seguir = false;
                        break;

                    default:
                        System.out.println("Seleccione una opción del menú");
                        break;
                }

            } catch (Exception NumberFormatExcpetion) {
                System.out.println("Debe ingresar un número");
            }
        }

        input.close();
    }
}