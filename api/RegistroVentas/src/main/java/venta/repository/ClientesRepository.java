package venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import venta.domain.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
