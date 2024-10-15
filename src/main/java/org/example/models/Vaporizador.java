package org.example.models;


import java.io.Serializable;

public class Vaporizador implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private double precio;

    public Vaporizador(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Vaporizador [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
    }
}
