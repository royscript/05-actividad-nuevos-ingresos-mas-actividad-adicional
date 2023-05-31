package cl.amisoft.usuarioapp.dao;

import cl.amisoft.usuarioapp.models.Usuarios;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuariosDao {
    @PersistenceContext
    protected EntityManager em;

    public Optional<Usuarios> obtenerUsuario(Long ccrUsuario) {
        TypedQuery<Usuarios> query = em.createQuery("Select u from Usuarios u where u.ccrUsuario = :ccrUsuario", Usuarios.class)
                .setParameter("ccrUsuario", ccrUsuario);
        Usuarios c = query.getResultList().isEmpty() ? null : query.getResultList().get(0);
        return Optional.ofNullable(c);
    }

    public List<Usuarios> listar() {
        return em.createQuery("from Usuarios u order by u.ccrUsuario asc", Usuarios.class).getResultList();
    }

    @Transactional
    public Usuarios agregar(Usuarios usuarios) {
        em.persist(usuarios);
        return usuarios;
    }

    @Transactional
    public Usuarios eliminar(Usuarios usuarios) {
        em.remove(usuarios);
        return usuarios;
    }

    @Transactional
    public Usuarios editar(Usuarios usuarios) {
        em.merge(usuarios);
        return usuarios;
    }
}
