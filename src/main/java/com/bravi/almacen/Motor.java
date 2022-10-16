package com.bravi.almacen;

public class Motor extends Componente {

    private int cantidadCilindros;
    private int cilindrada;

    public Motor(Integer numero, float precio, int cantidadCilindros, int cilindrada) {
        super(numero, precio);
        this.cantidadCilindros = cantidadCilindros;
        this.cilindrada = cilindrada;
    }

    public int getCantidadCilindros() {
        return cantidadCilindros;
    }

    public void setCantidadCilindros(int cantidadCilindros) {
        this.cantidadCilindros = cantidadCilindros;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString()
               + "\n\t\tMotor"
               + "\n\t\t\tCantidad Cilindros: " + cantidadCilindros
               + "\n\t\t\tCilindrada: " + cilindrada;
    }
}
