package publicaciones.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publicaciones.Services.AutorService;
import publicaciones.dto.AutorDTO;
import publicaciones.dto.ResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/publicaciones/autor")
public class AutorController {

    //inyeccion de dependencias
    @Autowired
    private AutorService service;

    @GetMapping
    public List<ResponseDTO> listarAutores(){
        return service.listarAutores();
    }

    @PostMapping
    public ResponseDTO crearAutor(@RequestBody AutorDTO autor){
        return service.crearAutor(autor);
    }

    @PutMapping("/{id}")
    public ResponseDTO actualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autor){
        return service.actualizarAutor(id, autor);
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarAutorPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarAutor(@PathVariable Long id){
        return service.eliminarAutor(id);
    }

}
