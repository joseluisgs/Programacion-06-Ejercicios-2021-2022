import models.Biblioteca;
import utils.Menu;

/**
 * @author Rocio PF
 * @version 1.0
 * github: Rochiio
 * Ejercicio del tema 5 con continuación en el tema 6
 */

public class Main {
    public static void main(String[] args){
        Biblioteca biblioteca = Biblioteca.getInstance();
        int option;

        do {
            option=Menu.optionMenu();
            biblioteca.menu(option);
        }while(option!=5);
    }
}
