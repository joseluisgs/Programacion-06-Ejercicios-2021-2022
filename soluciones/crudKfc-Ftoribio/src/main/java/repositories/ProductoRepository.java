package repositories;

import models.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * Repository para los productos siguiendo el TDA Mapa
 */
public class ProductoRepository extends TreeMap<String, Producto>
        implements ICRUDRepository<Producto, Integer> {

    /**
     * Busca un producto por su nombre
     * @param nombre nombre del producto
     * @return el producto encontrado o null si no lo encuentra
     */
    public Producto findByNombre(String nombre) {
        return this.get(nombre);
    }

    /**
     * Busca un producto por su id
     * @param id id del producto
     * @return el producto encontrado o null si no lo encuentra
     */
    @Override
    public Producto findById(Integer id) {
        for (Producto producto : this.values()) {
            if (producto.getId() == id)
                return producto;
        }
        return null;
    }

    /**
     * Devuelve una lista con los nombres de los productos
     * @return lista con los nombres de los productos
     */
    @Override
    public List<Producto> findAll() {
        return new ArrayList<>(this.values());
    }

    /**
     * Actualiza un producto
     * @param producto producto a actualizar con sus datos nuevos
     * @return el producto actualizado, null si no es posible
     */
    @Override
    public Producto update(Producto producto) {
        var res = this.findById(producto.getId());
        if (res != null) {
            this.remove(res.getNombre());
            return this.put(producto.getNombre(), producto);
        }
        return null;
    }

    /**
     * Elimina un producto
     * @param producto producto a eliminar
     * @return el pais eliminado
     */
    public Producto delete(Producto producto) {
        return this.remove(producto.getNombre());
    }

    /**
     * Borra un producto por su id
     * @param id id del producto a eliminar
     * @return el producto eliminado o null si no lo encuentra
     */
    @Override
    public Producto deleteById(Integer id) {
        var pais = this.findById(id);
        if (pais != null) {
            this.remove(pais.getNombre());
        }
        return null;
    }

    /**
     * Inserta un nuevo producto
     * @param producto
     * @return el producto insertado
     */
    @Override
    public Producto insert(Producto producto) {
        this.put(producto.getNombre(), producto);
        return producto;
    }

}