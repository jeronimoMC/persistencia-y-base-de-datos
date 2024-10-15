package org.example;

import models.Tienda;
import models.Vaporizador;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.cargarDesdeArchivo();

        Vaporizador v1 = new vaporizador(1, "Vape Pro", 120.00);
        Vaporizador v2 = new Vaporizador(2, "Vape Lite", 80.00);
        Vaporizador v3 = new Vaporizador(3, "Vape X", 150.00);

        tienda.agregar(v1);
        tienda.agregar(v2);
        tienda.agregar(v3);

        System.out.println("Todos los productos:");
        tienda.listar().forEach(System.out::println);
    }
}
