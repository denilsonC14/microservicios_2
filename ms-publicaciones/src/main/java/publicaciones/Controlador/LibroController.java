package publicaciones.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publicaciones.Services.LibroService;
import publicaciones.dto.LibroDTO;
import publicaciones.dto.ResponseDTO;

@RestController
@RequestMapping("/publicaciones/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseDTO listarLibros() {
        return libroService.listarLibros(); // Llama al servicio para obtener la lista de libros
    }

    @PostMapping
    public ResponseDTO crearLibro(@RequestBody LibroDTO dato) {
        return libroService.crearLibro(dato); // Llama al servicio para crear un nuevo libro
    }

    @PutMapping("/{id}")
    public ResponseDTO actualizarLibro(@PathVariable Long id, @RequestBody LibroDTO dato) {
        return libroService.actualizarLibro(id, dato); // Llama al servicio para actualizar un libro existente
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarLibroPorId(@PathVariable Long id) {
        return libroService.buscarLibroPorId(id); // Llama al servicio para buscar un libro por su ID
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarLibro(@PathVariable Long id) {
        return libroService.eliminarLibro(id); // Llama al servicio para eliminar un libro por su ID
    }
}
