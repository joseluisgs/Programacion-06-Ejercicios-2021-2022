package controllers;

import exceptions.ClientesExceptions;
import models.Cliente;
import repositories.ClientesRepository;
import java.util.ArrayList;
import java.util.List;

public class ClientesController {
    private static ClientesController instance;
    private final ClientesRepository clienteRepository;

    // Repositorio de la información
    List<Cliente> listaClientesRepository = new ArrayList<>();

    private ClientesController(ClientesRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        initRepositoryData();
    }

    public static ClientesController getInstance() {
        if (instance == null) {
            instance = new ClientesController(new ClientesRepository());
        }
        return instance;
    }

    /**
     * Añade un usuario al repositorio
     * @param nombre Nombre del usuario
     * @param edad   Edad del usuario
     * @return El usuario creado o null si no se ha podido crear
     */
    public Cliente crearUsuario(String nombre, int edad) {
        var cliente = new Cliente(nombre, edad);
        var res = listaClientesRepository.add(cliente);
        if (res) {
            return cliente;
        } else {
            return null;
        }
    }

    public Cliente crearCliente(Cliente cliente) throws ClientesExceptions {
        // Comprobamos que no haya datos incorrectos, por si ha fallado la interfaz
        checkClienteData(cliente);
        // comprobamos si existe
        var existe = clienteRepository.findById(cliente.getId());
        if (existe == null) {
            clienteRepository.insert(cliente);
            return cliente;
        }
        throw new ClientesExceptions("Ya existe un cliente con el id " + cliente.getId());
    }

    /**
     * Busca un usuario por su nombre
     *
     * @param nombre Nombre del usuario
     * @return El usuario o null si no se ha encontrado
     */
    public Cliente buscarPorNombre(String nombre) {
        for (var persona : listaClientesRepository) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }

    /**
     * Busca un usuario por su id
     * @param id id del usuario
     * @return El usuario o null si no se ha encontrado
     */
    public Cliente buscarPorId(int id) {
        for (var cliente : listaClientesRepository) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Elimina un usuario del repositorio dado su nombre
     * @param nombre Nombre del usuario
     * @return El usuario o null si no se ha completado con éxito
     */
    public Cliente eliminarPorPorNombre(String nombre) {
        var cliente = buscarPorNombre(nombre);
        if (cliente != null) {
            if (listaClientesRepository.remove(cliente)) {
                return cliente;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Elimina un usuario del repositorio dado su id
     * @param id id del cliente
     * @return El cliente o null si no se ha completado con éxito
     */
    public Cliente eliminarPorId(int id) {
        var cliente = buscarPorId(id);
        if (cliente != null) {
            if (listaClientesRepository.remove(cliente)) {
                return cliente;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Actualiza los datos de una persona
     * @param nombre nombre de la persona a cambiar los datos
     * @param nuevosDatos nuevos datos de la persona
     * @return El usuario o null si no se ha completado con éxito
     */
    public Cliente actualizarUsuarioPorNombre(String nombre, Cliente nuevosDatos) {
        var cliente = buscarPorNombre(nombre);
        if (cliente != null) {
            cliente.setNombre(nuevosDatos.getNombre());
            cliente.setEdad(nuevosDatos.getEdad());
            return cliente;
        } else {
            return null;
        }
    }

    /**
     * Devuelve todos los usuarios del repositorio
     * @return Lista de usuarios
     */
    public List<Cliente> obtenerTodos() {
        return listaClientesRepository;
    }

    private void initRepositoryData() {
        this.listaClientesRepository.add(new Cliente("Francisco", 42));
        this.listaClientesRepository.add(new Cliente("Laura", 40));
        this.listaClientesRepository.add(new Cliente("Elena", 30));
        this.listaClientesRepository.add(new Cliente("Silvia", 46));
    }

    /**
     * Comprueba que los datos del cliente son correctos
     * @param cliente
     * @throws ClientesExceptions
     */
    private void checkClienteData(Cliente cliente) throws ClientesExceptions {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new ClientesExceptions("El nombre del cliente no puede estar vacío");
        }
        if (cliente.getEdad() == 0) {
            throw new ClientesExceptions("La edad debe ser mayor a 0");
        }

    }
}
