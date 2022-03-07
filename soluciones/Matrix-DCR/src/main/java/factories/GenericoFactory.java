package factories;

import models.Generico;
import models.Localizacion;

import java.util.List;

public class GenericoFactory {
    public static Generico createRandom() {
        List<String> nombre = List.of("Pepe", "Juan", "Ana", "Sonia", "Pedro", "Chiquito", "Elena");
        List<String> ciudad = List.of("New York", "Pekín", "Roma", "Paris", "Londres", "Caracuel");
        Localizacion localizacion = new Localizacion(
                ciudad.get((int) (Math.random() * ciudad.size()))
        );
        return new Generico(
                nombre.get((int) (Math.random() * nombre.size())),
                localizacion
        );
    }
}
