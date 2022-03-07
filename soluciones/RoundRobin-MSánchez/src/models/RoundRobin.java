package models;


import java.util.ArrayList;

public class RoundRobin extends ArrayList implements ICola {
    private float tiempoCPU = 0.2f;
    private float quantum = randomQuantum();
    private ArrayList<Proceso> CPU =new ArrayList();

    public void crearProceso(){
        Proceso proceso = new Proceso ();
        almacenarProceso(proceso);
    }

    public void almacenarProceso(Proceso proceso){
        enqueue(proceso, CPU);
    }

    public void logistica() {
        for(int i = 0; i < CPU.size(); i++) {
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}
            System.out.println("Trabajando en el proceso " + CPU.get(i).getIdentidad() + "...");
            reajustarTiempo(i);
        }
    }

    private void reajustarTiempo(int i) {
        CPU.get(i).setTiempo(CPU.get(i).getTiempo()-tiempoCPU);
        if(CPU.get(i).getTiempo() <= 0){
            System.out.println("El proceso " + CPU.get(i).getIdentidad() + " ha terminado.");
            dequeue(CPU);
        }else{
            enqueue(dequeue(CPU),CPU);
        }
    }

    private void controlarPrioridad(){

    }

    public float randomQuantum(){
        return (float)((Math.random()*(4-1+1)+1)*100/100);
    }

    @Override
    public void enqueue(Proceso proceso, ArrayList CPU) {
        this.add(CPU.size()-1,proceso);
    }

    @Override
    public Proceso dequeue( ArrayList CPU) {
        return (Proceso) CPU.remove(0);
    }

    @Override
    public Proceso first() {
        return CPU.get(0);
    }
}
