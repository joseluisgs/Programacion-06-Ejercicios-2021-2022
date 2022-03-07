package factories;

import models.Localizacion;
import models.Smith;

import java.util.List;

public class SmithFactory {
    public static Smith createRandom() {
        List<String> ciudad = List.of("New York", "Pekín", "Roma", "Paris", "Londres", "Caracuel");
        Localizacion localizacion = new Localizacion(
                ciudad.get((int) (Math.random() * ciudad.size()))
        );
        return new Smith(
                localizacion
        );
    }
}
