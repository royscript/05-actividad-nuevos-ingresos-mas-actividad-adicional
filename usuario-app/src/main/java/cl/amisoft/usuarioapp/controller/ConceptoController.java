package cl.amisoft.usuarioapp.controller;

import cl.amisoft.usuarioapp.service.ConceptoService;
import cl.amisoft.usuarioapp.vo.ConceptoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("concepto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT})
public class ConceptoController {
    @Autowired
    private final ConceptoService conceptoService;

    public ConceptoController(ConceptoService conceptoService) {
        this.conceptoService = conceptoService;
    }
    @GetMapping()
    public List<ConceptoVo> getAll(){
        return conceptoService.listar();
    }
}
