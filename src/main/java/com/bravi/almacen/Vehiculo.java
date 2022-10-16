package com.bravi.almacen;

import java.util.List;

public class Vehiculo {

    private int peso;
    private List<Componente> parte;

    public Vehiculo(int peso, List<Componente> parte) {
        this.peso = peso;
        this.parte = parte;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public List<Componente> getParte() {
        return parte;
    }

    public void setParte(List<Componente> parte) {
        this.parte = parte;
    }

    @Override
    public String toString() {
        return "\n\tVehiculo"
                + "\n\tPeso: " + peso
                + "\n\tParte 1: " + parte.get(0)
                + "\n\tParte 2: " + parte.get(1);
    }
}
