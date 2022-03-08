import models.RoundRobin;

public class Main {
    public static void main(String[] args) {
        RoundRobin sistema = new RoundRobin();
        float tiempoEjecucion = 0;
        do {
            sistema.crearProceso();
            sistema.logistica();
            tiempoEjecucion = tiempoEjecucion-2.2f;
        }while(tiempoEjecucion<60);
    }
}
