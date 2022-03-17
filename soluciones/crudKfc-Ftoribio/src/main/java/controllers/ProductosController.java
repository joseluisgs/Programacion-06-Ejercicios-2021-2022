package controllers;

import models.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductosController {
    private static ProductosController instance;

    // Repositorio de la información
    List<Producto> productosRepository = new ArrayList<>();

    private ProductosController() {
        productosRepository.add(new Producto("Menú 1", 10, 10));
        productosRepository.add(new Producto("Menú 2", 15.5, 5));
        productosRepository.add(new Producto("Menú 3",  20, 7));
        productosRepository.add(new Producto("Menú 4", 23.5, 67));
        productosRepository.add(new Producto("Bebida pequeña",3,100));
        productosRepository.add(new Producto("Bebida mediana",4.5,50));
        productosRepository.add(new Producto("Bebida grande",5,25));
        productosRepository.add(new Producto("Alitas pequeñas",4,100));
        productosRepository.add(new Producto("Alitas medianas",4.5,100));
        productosRepository.add(new Producto("Alitas grandes",5.2,100));
        productosRepository.add(new Producto("3 Salsas",2,500));
        productosRepository.add(new Producto("5 Salsas",2.5,500));
        productosRepository.add(new Producto("7 Salsas",3,500));
        productosRepository.add(new Producto("Postre pequeño",2,100));
        productosRepository.add(new Producto("Postre mediano",2.5,100));
        productosRepository.add(new Producto("Postre grande",2.8,100));
    }

    public static ProductosController getInstance() {
        if (instance == null) {
            instance = new ProductosController();
        }
        return instance;
    }

    /**
     * Obtiene un producto dado su id
     * @param id id del producto
     * @return producto con el id dado o null si no existe
     */
    public Producto getProducto(int id) {
        for (Producto producto : productosRepository) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Actualiza el stock de un producto dado un id
     * @param id id del producto
     * @param cantidad a retirar del stock del producto
     */
    public void actualizarExistencias(int id, int cantidad) {
        for (Producto producto : productosRepository) {
            if (producto.getId() == producto.getId()) {
                producto.setStock(producto.getStock()-cantidad);
            }
        }
    }

    @Override
    public String toString() {
        return "Productos disponibles:" + "\n" + productosRepository;
    }
}
