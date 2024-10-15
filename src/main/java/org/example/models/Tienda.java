package org.example.models;

import interfaces.CrudOperations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tienda implements CrudOperations<Vaporizador>, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Vaporizador> inventario = new ArrayList<>();
    private final String archivo = "data/productos.dat";

    @Override
    public void agregar(Vaporizador vaporizador) {
        inventario.add(vaporizador);
        guardarEnArchivo();
    }

    @Override
    public Vaporizador obtener(int id) {
        return inventario.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void actualizar(int id, Vaporizador vaporizadorActualizado) {
        Vaporizador vaporizador = obtener(id);
        if (vaporizador != null) {
            vaporizador.setPrecio(vaporizadorActualizado.getPrecio());
            guardarEnArchivo();
        }
    }

    @Override
    public void eliminar(int id) {
        inventario.removeIf(v -> v.getId() == id);
        guardarEnArchivo();
    }

    @Override
    public List<Vaporizador> listar() {
        return inventario;
    }

    public void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            inventario = (List<Vaporizador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            inventario = new ArrayList<>();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(inventario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
