import controllers.ProductosController;
import controllers.ClientesController;
import controllers.VentasController;
import view.Menu;

public class Main {

    private static final ClientesController clienteController = ClientesController.getInstance();
    private static final VentasController ventasController = VentasController.getInstance();
    private static final ProductosController productosController = ProductosController.getInstance();
    private static final Menu menu = Menu.getInstance();

    public static void main(String[] args) {
        menu.menu();
    }
}

