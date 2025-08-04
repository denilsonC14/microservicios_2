package publicaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publicaciones.entity.Autor;

//hereda desde JpaRepository que devuelve todas las CRUD de autor
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
