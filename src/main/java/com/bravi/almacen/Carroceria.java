package com.bravi.almacen;

public class Carroceria extends Componente {

    private String descripcion;
    private String color;

    public Carroceria(Integer numero, float precio, String descripcion, String color) {
        super(numero, precio);
        this.descripcion = descripcion;
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\t\tCarroceria"
                + "\n\t\t\tDescripcion: " + descripcion
                + "\n\t\t\tColor: " + color;
    }
}
