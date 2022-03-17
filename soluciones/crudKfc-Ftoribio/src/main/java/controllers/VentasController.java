package controllers;

import models.LineaVenta;
import models.Cliente;
import models.Producto;
import models.Venta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VentasController {
    private static VentasController instance;
    // Otros controladores que necesito o repositorios
    private ProductosController productosController;
    List<Venta> ventasRepository;

    private VentasController() {
        productosController = ProductosController.getInstance();
        ventasRepository = new ArrayList<>();
    }

    public static VentasController getInstance() {
        if (instance == null) {
            instance = new VentasController();
        }
        return instance;
    }

    /**
     * Añade una nueva venta al repositorio de ventas
     * @param cliente Cliente de la venta
     * @param datosLinea Venta en formato Map<idProducto, cantidad>
     * @return Venta creada
     * @throws Exception Si no se puede crear la venta o existe problemas de stock
     */
    public Venta realizarVenta(Cliente cliente, Map<Integer, Integer> datosLinea)
            throws Exception {
        Venta venta = new Venta(cliente);
        for (int id: datosLinea.keySet()) {
            Producto producto = productosController.getProducto(id);
            var exist = producto.getStock();
            if (exist > 0 && exist >= datosLinea.get(id)) {
                // Actualizo el stock. Como va por referencia se ha actualizado,
                // si no fuerzo, como si fuera una BBDD
                productosController.actualizarExistencias(id, datosLinea.get(id));
                // Creo la línea de venta
                LineaVenta linea = new LineaVenta(producto, datosLinea.get(id));
                // la inserto
                venta.insertarLinea(linea);

            } else {
                throw new Exception("No hay stock suficiente para el producto "
                        + producto.getNombre());
            }
        }
        // Calculo el total
        venta.calcularTotal();
        // Lo inserto en el repositorio
        ventasRepository.add(venta);
        return venta;
    }
}
