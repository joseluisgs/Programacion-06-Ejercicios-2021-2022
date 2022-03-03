import models.Dvd;
import models.Ficha;
import models.Libro;
import models.Revista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestFichaYHerencia {
    private static Ficha dvd;
    private static Ficha revista;
    private static Ficha libro;


    @BeforeAll
    public static void setUp(){
        dvd = new Dvd("pepe","paco",2000,"documental");
        revista = new Revista("hola",15,2022);
        libro = new Libro("diario","manolo","sbn");
    }

    @Test
    @DisplayName("Getters Dvd")
    public void testGetterDvd(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("pepe", dvd.getTittle()),
                () -> Assertions.assertEquals("paco", ((Dvd)dvd).getDirector()),
                () -> Assertions.assertEquals(2000, ((Dvd)dvd).getYear()),
                () -> Assertions.assertEquals("documental", ((Dvd)dvd).getType())
        );
    }


    @Test
    @DisplayName("Getters Revista")
    public void testGetterRevista(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("hola", revista.getTittle()),
                () -> Assertions.assertEquals(15, ((Revista)revista).getNumeroRevista()),
                () -> Assertions.assertEquals(2022, ((Revista)revista).getYearPblicacion())
        );
    }


    @Test
    @DisplayName("Getters Libro")
    public void testGetterLibro(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("diario", libro.getTittle()),
                () -> Assertions.assertEquals("manolo", ((Libro)libro).getAutor()),
                () -> Assertions.assertEquals("sbn", ((Libro)libro).getEditorial())
        );
    }
}
