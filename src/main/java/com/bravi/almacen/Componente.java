package com.bravi.almacen;

public abstract class Componente {

    private Integer numero;
    private float precio;

    public Componente(Integer numero, float precio) {
        this.numero = numero;
        this.precio = precio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n\t\tComponente"
                + "\n\t\t\tNumero: " + numero
                + "\n\t\t\tPrecio: " + precio;
    }
}
