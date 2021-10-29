package venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import venta.domain.model.Productos;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Long> {
}
