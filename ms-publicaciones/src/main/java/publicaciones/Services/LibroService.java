package publicaciones.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publicaciones.Repository.AutorRepository;
import publicaciones.Repository.LibroRepository;
import publicaciones.dto.LibroDTO;
import publicaciones.dto.ResponseDTO;
import publicaciones.entity.Autor;
import publicaciones.entity.Libro;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;

    public ResponseDTO crearLibro(LibroDTO dato) {
        Libro libro = new Libro();
        libro.setTitulo(dato.getTitulo());
        libro.setAnioPublicacion(dato.getAnioPublicacion());
        libro.setEditorial(dato.getEditorial());
        libro.setIsbn(dato.getIsbn());
        libro.setResumen(dato.getResumen());
        libro.setIdioma(dato.getIdioma());
        libro.setGenero(dato.getGenero());
        libro.setNumeroPaginas(dato.getNumeroPaginas());
        libro.setEdicion(dato.getEdicion());

        // Buscar y asignar el autor
        Autor autor = autorRepository.findById(dato.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Autor con id " + dato.getIdAutor() + " no encontrado"));
        libro.setAutor(autor);

        return new ResponseDTO(
                "Libro registrado correctamente",
                libroRepository.save(libro) // Guarda el libro en la base de datos
        );
    }

    public ResponseDTO actualizarLibro(Long id, LibroDTO dato) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " no encontrado"));

        libro.setTitulo(dato.getTitulo());
        libro.setAnioPublicacion(dato.getAnioPublicacion());
        libro.setEditorial(dato.getEditorial());
        libro.setIsbn(dato.getIsbn());
        libro.setResumen(dato.getResumen());
        libro.setIdioma(dato.getIdioma());
        libro.setGenero(dato.getGenero());
        libro.setNumeroPaginas(dato.getNumeroPaginas());
        libro.setEdicion(dato.getEdicion());

        // Buscar y asignar el autor
        Autor autor = autorRepository.findById(dato.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Autor con id " + dato.getIdAutor() + " no encontrado"));
        libro.setAutor(autor);

        return new ResponseDTO(
                "Libro actualizado correctamente",
                libroRepository.save(libro) // Guarda el libro en la base de datos
        );
    }

    public ResponseDTO listarLibros() {
        return new ResponseDTO(
                "Lista de libros",
                libroRepository.findAll() // Obtiene todos los libros de la base de datos
        );
    }

    public ResponseDTO buscarLibroPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " no encontrado"));

        return new ResponseDTO(
                "Libro encontrado",
                libro // Devuelve el libro encontrado
        );
    }

    public ResponseDTO eliminarLibro(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con id " + id + " no encontrado"));

        libroRepository.delete(libro); // Elimina el libro de la base de datos

        return new ResponseDTO(
                "Libro eliminado correctamente",
                null // No se devuelve ningún objeto, solo un mensaje
        );
    }
}
