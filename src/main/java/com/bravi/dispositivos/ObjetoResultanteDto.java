package com.bravi.dispositivos;

public class ObjetoResultanteDto {
    private String marca;
    private int peso;
    private int numero;
    private float precio;
    private int cilindrada;
    private int cilindros;
    private String descripcion;
    private String color;

    public ObjetoResultanteDto(String marca, int peso, int numero, float precio, int cilindrada, int cilindros, String descripcion, String color) {
        this.marca = marca;
        this.peso = peso;
        this.numero = numero;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.cilindros = cilindros;
        this.descripcion = descripcion;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public int getPeso() {
        return peso;
    }

    public int getNumero() {
        return numero;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getCilindros() {
        return cilindros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getColor() {
        return color;
    }
}
