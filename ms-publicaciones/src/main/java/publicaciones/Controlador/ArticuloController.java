package publicaciones.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import publicaciones.Services.ArticuloService;
import publicaciones.dto.ArticuloDTO;
import publicaciones.dto.ResponseDTO;

@RestController
@RequestMapping("/publicaciones/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public ResponseDTO listarArticulos() {
        return articuloService.listarArticulos(); // Llama al servicio para obtener la lista de artículos
    }

    @PostMapping
    public ResponseDTO crearArticulo(@RequestBody ArticuloDTO dato) {
        return articuloService.crearArticulo(dato); // Llama al servicio para crear un nuevo artículo
    }

    @PutMapping("/{id}")
    public ResponseDTO actualizarArticulo(@PathVariable Long id, @RequestBody ArticuloDTO dato) {
        return articuloService.actualizarArticulo(id, dato); // Llama al servicio para actualizar un artículo existente
    }

    @GetMapping("/{id}")
    public ResponseDTO buscarArticuloPorId(@PathVariable Long id) {
        return articuloService.buscarArticuloPorId(id); // Llama al servicio para buscar un artículo por su ID
    }

    @DeleteMapping("/{id}")
    public ResponseDTO eliminarArticulo(@PathVariable Long id) {
        return articuloService.eliminarArticulo(id); // Llama al servicio para eliminar un artículo por su ID
    }
}
