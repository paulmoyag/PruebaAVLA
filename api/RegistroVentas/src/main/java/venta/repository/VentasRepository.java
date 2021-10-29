package venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import venta.domain.model.Ventas;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
}
