package com.company.models;

import java.util.Objects;

public class Proceso implements Comparable<Proceso> {
    private int id;
    private static int contadorId=0;
    private String pNumero;
    private float quantum;
    private int prioridad;

    public Proceso(){
        this.id= ++contadorId;
        this.pNumero= generarNombre();
        setQuantum(generarQuantum());
        setPrioridad(generarPrioridad());

    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getpNumero() {
        return pNumero;
    }

    public void setpNumero(String pNumero) {
        this.pNumero = pNumero;
    }

    public float getQuantum() {
        return quantum;
    }

    public void setQuantum(float quantum) {
        this.quantum = quantum;
    }

    public int generarQuantum(){
        return (int)(Math.random()* 4 + 1);
    }
    public int generarPrioridad(){
        return (int)(Math.random()* 4);
    }

    private String generarNombre(){
        StringBuilder sb = new StringBuilder("P");
        sb.append(id);

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Proceso: " + pNumero + '\'' +
                ", quantum: " + quantum + "sg" +
                ", prioridad: " + prioridad+ "|";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proceso proceso = (Proceso) o;
        return id == proceso.id && quantum == proceso.quantum && prioridad == proceso.prioridad && pNumero.equals(proceso.pNumero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pNumero, quantum, prioridad);
    }

    @Override
    public int compareTo(Proceso o) {
        int res= o.prioridad - this.prioridad;
        if (res==0) res= this.pNumero.compareTo(o.pNumero);
        return res;
    }
}

