package es.fp.cajero.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fp.cajero.modelo.beans.Movimiento;

public interface IntMovimientosRepository extends JpaRepository<Movimiento, Integer>{

}
