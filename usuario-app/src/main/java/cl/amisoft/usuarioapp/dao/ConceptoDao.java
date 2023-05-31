package cl.amisoft.usuarioapp.dao;

import cl.amisoft.usuarioapp.models.Concepto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConceptoDao {
    @PersistenceContext
    protected EntityManager em;
    public List<Concepto> listar() {
        return em.createQuery("from Concepto c order by c.codConcepto asc", Concepto.class).getResultList();
    }
}
