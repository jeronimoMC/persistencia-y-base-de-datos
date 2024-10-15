package service;

import Vaporizador;
import repositories.JpaVaporizadorRepository;

import java.util.List;

public class VaporizadorServiceImpl implements VaporizadorService {
    private JpaVaporizadorRepository repository = new JpaVaporizadorRepository();

    @Override
    public void agregar(Vaporizador vaporizador) {
        repository.agregar(vaporizador);
    }

    @Override
    public Vaporizador obtener(int id) {
        return repository.obtener(id);
    }

    @Override
    public void actualizar(Vaporizador vaporizador) {
        repository.actualizar(vaporizador);
    }

    @Override
    public void eliminar(int id) {
        repository.eliminar(id);
    }

    @Override
    public List<Vaporizador> listar() {
        return repository.listar();
    }

    public void cerrar() {
        repository.cerrar();
    }
}
