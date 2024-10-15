package Repository;


import Vaporizador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaVaporizadorRepository implements VaporizadorRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("vapeShopPU");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void agregar(Vaporizador vaporizador) {
        em.getTransaction().begin();
        em.persist(vaporizador);
        em.getTransaction().commit();
    }

    @Override
    public Vaporizador obtener(int id) {
        return em.find(Vaporizador.class, id);
    }

    @Override
    public void actualizar(Vaporizador vaporizador) {
        em.getTransaction().begin();
        em.merge(vaporizador);
        em.getTransaction().commit();
    }

    @Override
    public void eliminar(int id) {
        em.getTransaction().begin();
        Vaporizador vaporizador = em.find(Vaporizador.class, id);
        if (vaporizador != null) {
            em.remove(vaporizador);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Vaporizador> listar() {
        return em.createQuery("FROM Vaporizador", Vaporizador.class).getResultList();
    }

    public void cerrar() {
        em.close();
        emf.close();
    }
}

