
import controller.BibliotecaController;
import models.Dvd;
import models.Ficha;

import models.Libro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBibliotecaController {

    static BibliotecaController controlador;
    static ArrayList<Ficha> listaFichas;

    @BeforeAll
    public static void setUp() {
        controlador = new BibliotecaController();
        listaFichas = new ArrayList<>();
        listaFichas.add(new Libro("After","Anna Todd","Wattpad"));
        listaFichas.add(new Dvd("Mamma mia","ABBA",2012,"musical"));
    }


    @Test
    @DisplayName("Test BibliotecaControllerSearch")
    public void testSearch(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(0, controlador.search(1,listaFichas)),
                () -> Assertions.assertEquals(1, controlador.search(2, listaFichas)),
                () -> Assertions.assertEquals(-1, controlador.search(3,listaFichas))
        );
    }
}
