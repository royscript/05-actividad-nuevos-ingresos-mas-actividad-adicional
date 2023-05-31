package cl.amisoft.usuarioapp.service.impl;

import cl.amisoft.usuarioapp.dao.ConceptoDao;
import cl.amisoft.usuarioapp.service.ConceptoService;
import cl.amisoft.usuarioapp.vo.ConceptoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConceptoServiceImpl implements ConceptoService {
    private final ConceptoDao conceptoDao;
    @Autowired
    public ConceptoServiceImpl(ConceptoDao conceptoDao) {
        this.conceptoDao = conceptoDao;
    }

    @Override
    public List<ConceptoVo> listar() {
        return conceptoDao.listar().stream().map(
          c -> new ConceptoVo.Builder()
                  .codConcepto(c.getCodConcepto())
                  .glsConcepto(c.getGlsConcepto())
                  .fecCreacion(c.getFecCreacion())
                  .flgActivo(c.getFlgActivo())
                .build())
                .collect(Collectors.toList());
    }
}
