package es.ftoribio.dam.models;

import es.ftoribio.dam.controller.BibliotecaController;
import es.ftoribio.dam.utils.Pedir;
import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca{
    private static Biblioteca instance = null;
    private final ArrayList<Ficha> bibliotecaRepository;
    private final BibliotecaController controladorBiblio;

    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
      return instance;
    }

    public Biblioteca() {
        bibliotecaRepository = new ArrayList<>();
        controladorBiblio = new BibliotecaController();
    }

    public void menu(int option){
        switch (option){
            case 1: addItem();
            break;
            case 2: searchItem();
            break;
            case 3: removeItem();
            break;
            case 4: listBiblio();
            break;
            case 5: System.out.println("\nGracias, adiós 👋");
            break;
        }
    }

    private void listBiblio() {
        if (bibliotecaRepository.size()==0){
            System.out.println("Biblioteca Vacía");
        }else{
            Collections.sort(bibliotecaRepository);
            System.out.println(bibliotecaRepository);
        }
    }


    private void removeItem() {
        int id = Pedir.pedirInt("Dime el ID a eliminar");
        int buscada=controladorBiblio.search(id, bibliotecaRepository);
        if (buscada == -1){
            System.out.println("Esta ficha no ha sido encontrada");
        }else {
            bibliotecaRepository.remove(buscada);
            System.out.println("Ficha eliminada");
        }
    }


    private void searchItem() {
        int id = Pedir.pedirInt("Dime el ID a buscar");
        int buscada=controladorBiblio.search(id, bibliotecaRepository);
        if (buscada == -1){
            System.out.println("Esta ficha no ha sido encontrada");
        }else {
            System.out.println(bibliotecaRepository.get(buscada));
        }
    }


    private void addItem() {
        bibliotecaRepository.add(controladorBiblio.add());
        System.out.println(bibliotecaRepository.get(bibliotecaRepository.size()-1));
    }

}
