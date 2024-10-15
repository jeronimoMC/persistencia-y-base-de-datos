package service;

import Vaporizador;

import java.util.List;

public interface VaporizadorService {
    void agregar(Vaporizador vaporizador);
    Vaporizador obtener(int id);
    void actualizar(Vaporizador vaporizador);
    void eliminar(int id);
    List<Vaporizador> listar();
}
