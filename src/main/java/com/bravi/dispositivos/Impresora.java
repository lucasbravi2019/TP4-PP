package com.bravi.dispositivos;

import com.bravi.almacen.*;

import java.io.IOException;
import java.util.List;

public class Impresora {

    public void grabar(ObjetoResultanteDto dto) throws IOException {
        Componente motor = new Motor(dto.getNumero(), dto.getPrecio(), dto.getCilindros(), dto.getCilindrada());
        Componente carroceria = new Carroceria(dto.getNumero(), dto.getPrecio(), dto.getDescripcion(), dto.getColor());
        Vehiculo vehiculo = new Vehiculo(dto.getPeso(), List.of(motor, carroceria));
        Inventario inventario = new Inventario(dto.getMarca());
        inventario.agregar(vehiculo);
        inventario.listar();
        inventario.persistir();
    }
}
