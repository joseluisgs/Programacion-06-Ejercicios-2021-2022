package repositories;

import models.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ClientesRepository extends TreeMap<Integer, Cliente> implements ICRUDRepository<Cliente, Integer> {
    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(this.values());
    }

    @Override
    public Cliente insert(Cliente cliente) {
        this.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        var res = this.findById(cliente.getId());
        if (res != null) {
            this.remove(res.getId());
            return this.put(cliente.getId(), cliente);
        }
        return null;
    }

    @Override
    public Cliente findById(Integer integer) {
        return null;
    }

    @Override
    public Cliente deleteById(Integer id) {
        var cliente = this.findById(id);
        if (cliente != null) {
            this.remove(cliente.getNombre());
        }
        return null;
    }


}
