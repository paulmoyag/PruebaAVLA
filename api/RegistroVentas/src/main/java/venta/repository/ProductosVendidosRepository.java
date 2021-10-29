package venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import venta.domain.model.ProductosVendidos;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductosVendidosRepository extends JpaRepository<ProductosVendidos, Long> {
}
