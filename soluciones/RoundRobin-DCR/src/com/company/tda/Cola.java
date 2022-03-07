package com.company.tda;

import java.util.ArrayDeque;
import java.util.TreeSet;

public class Cola<E> extends TreeSet<E> implements ICola<E> {

    @Override
    public void encolar(E e) {
        this.add(e);
    }

    @Override
    public E desencolar() {
        return this.pollFirst();
    }

    @Override
    public boolean esVacia() {
        return this.isEmpty();
    }

    @Override
    public int longitud() {
        return this.size();
    }

    @Override
    public E primero() {
        return this.first();
    }

    @Override
    public String toString() {
        return "Cola{" + super.toString() + "}";
    }
}
