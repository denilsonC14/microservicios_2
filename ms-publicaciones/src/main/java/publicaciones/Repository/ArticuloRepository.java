package publicaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publicaciones.entity.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
