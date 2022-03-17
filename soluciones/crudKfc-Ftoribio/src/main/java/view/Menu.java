package view;

import controllers.ClientesController;
import controllers.ProductosController;
import controllers.VentasController;
import models.Cliente;
import utils.Console;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static Menu instance;

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
    private static final ClientesController clienteController = ClientesController.getInstance();
    private static final VentasController ventasController = VentasController.getInstance();
    private static final ProductosController productosController = ProductosController.getInstance();

    public void menu() {

    System.out.println("KFC");
        System.out.println("=================");
    // Bucle infinito a la espera de una opción o salir
        do {
        System.out.println();
        System.out.println("1. Gestionar clientes");
        System.out.println("2. Gestionar ventas");
        System.out.println("3. Salir");
        String opcion = Console.getString("Elige una opción [1-3]: ");
        // Expresion regular para validar la opción
        var regex = "[1-3]";
        if (opcion.matches(regex)) {
            switch (opcion) {
                case "1":
                    gestionClientes();
                    break;
                case "2":
                    gestionVentas();
                    break;
                case "3":
                    salir();
                    break;
            }
        }
    } while (true);
}

    public static void gestionClientes() {
        do {
            System.out.println();
            System.out.println("1. Crear cliente nuevo");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Mostrar clientes");
            System.out.println("6. Salir");
            System.out.println();
            String opcion = Console.getString("Elige una opción [1-6]: ");
            // Expresion regular para validar la opción
            var regex = "[1-6]";
            if (opcion.matches(regex)) {
                switch (opcion) {
                    case "1":
                        nuevoCliente();
                        break;
                    case "2":
                        buscarCliente();
                        break;
                    case "3":
                        actualizarCliente();
                        break;
                    case "4":
                        eliminarCliente();
                        break;
                    case "5":
                        mostrarClientes();
                        break;
                    case "6":
                        salir();
                        break;
                }
            }
        } while (true);
    }

    /**
     * Salir del programa
     */
    private static void salir() {
        System.out.println("¡Hasta pronto!");
        System.exit(0);
    }

    private static void nuevoCliente() {
        var sal = clienteController.crearUsuario(Console.
                getString("Introduce tu nombre"),Console.getInt("Introduce tu edad"));
        if (sal!=null) {
            System.out.println("Usuario creado: " + sal);
        } else {
            System.out.println("Usuario no creado");
        }
    }

    private static void buscarCliente() {
        var sal2 = clienteController.buscarPorNombre(Console.getString("Introduce el nombre"));
        if (sal2 != null) {
            System.out.println("Usuario encontrado: " + sal2);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private static void actualizarCliente() {
        var nuevosDatos = new Cliente(Console.getString("Introduce el nombre"),Console
                .getInt("Introduce tu edad"));
        var sal3 = clienteController.actualizarUsuarioPorNombre(Console
                .getString("Introduce el nombre"), nuevosDatos);
        if (sal3 != null) {
            System.out.println("Usuario actualizado: " + sal3);
        } else {
            System.out.println("Usuario no actualizado");
        }
    }

    private static void eliminarCliente() {
        System.out.println("4. Delete: Eliminar usuario");
        var sal4 = clienteController.eliminarPorPorNombre(Console.
                getString("Introduce el nombre"));
        if (sal4!=null) {
            System.out.println("Usuario eliminado: " + sal4);
        } else {

            System.out.println("Usuario no eliminado");
        }
    }

    private static void mostrarClientes() {
        var res = clienteController.obtenerTodos();
        if (res != null) {
            System.out.println("Usuarios encontrados: " + res);
        }
    }

    private static void gestionVentas() {

        System.out.println();
        System.out.println("Secuencia de Ventas");
        System.out.println("==================");
        System.out.println("");

        // Creamos o buscamos el cliente
        var cliente = clienteController.crearUsuario(Console.
                getString("Introduce el nombre: "),Console.getInt("Introduce la edad: "));

        Map<Integer,Integer> datosLinea = new HashMap<>();
        System.out.println(productosController.toString());
        datosLinea.put(Console.getInt("Introduce el código de producto"),
                Console.getInt("Introduce la cantidad: "));

        try {
            var res = ventasController.realizarVenta(cliente, datosLinea);
            System.out.println("Venta realizada: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
