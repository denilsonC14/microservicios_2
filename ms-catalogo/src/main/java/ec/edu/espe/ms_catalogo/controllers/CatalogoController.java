package ec.edu.espe.ms_catalogo.controllers;

import ec.edu.espe.ms_catalogo.entities.Catalogo;
import ec.edu.espe.ms_catalogo.services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping
    public List<Catalogo> listarCatalogo() {
        return catalogoService.listarCatalogo();
    }
}
