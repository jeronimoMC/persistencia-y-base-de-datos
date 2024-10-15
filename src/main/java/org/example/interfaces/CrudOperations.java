package org.example.interfaces;

import java.util.List;

public interface CrudOperations<T> {
    void agregar(T item);
    T obtener(int id);
    void actualizar(int id, T item);
    void eliminar(int id);
    List<T> listar();
}

