import models.Matrix;

public class Main {
    public static void main(String[] args) {

        // Crear dimension matrix
        Matrix matrix = Matrix.getInstance(5);
        // Posicionar personajes
        matrix.iniciar();

        matrix.simulacionMatrix();


        matrix.informe();

    }
}
