package com.bravi.almacen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private String marca;
    private List<Vehiculo> item = new ArrayList<>();

    public Inventario(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Vehiculo> getItem() {
        return item;
    }

    public void setItem(List<Vehiculo> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Inventario"
                + "\nMarca: " + marca
                + "\nItem: " + item.get(0);
    }

    public void agregar(Vehiculo vehiculo) {
        if (vehiculo != null) {
            item.add(vehiculo);
        }
    }

    public void listar() {
        System.out.println("*****Inventario*****");
        System.out.println("Marca: " + marca);
        System.out.println("*****Vehiculos*****");
        item.forEach(vehiculo -> {
            System.out.println("Peso: " + vehiculo.getPeso() + " kg");
            System.out.println("*****Componentes*****");
            System.out.println("Número: " + vehiculo.getParte().get(0).getNumero());
            System.out.printf("Precio: $%.2f\n", vehiculo.getParte().get(0).getPrecio());
            Motor motor = (Motor) vehiculo.getParte().get(0);
            System.out.println("*****Motor*****");
            System.out.println("Cilindrada: " + motor.getCilindrada());
            System.out.println("Cantidad Cilindros: " + motor.getCantidadCilindros());
            Carroceria carroceria = (Carroceria) vehiculo.getParte().get(1);
            System.out.println("*****Carrocería*****");
            System.out.println("Color: " + carroceria.getColor());
            System.out.println("Descripción: " + carroceria.getDescripcion());
        });
    }

    public void persistir() throws IOException {
        String texto = getTextToPersist();
        File file = new File("inventario.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(texto.getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.close();
        fileOutputStream.close();
    }

    private String getTextToPersist() {
        return this.toString();
    }
}

