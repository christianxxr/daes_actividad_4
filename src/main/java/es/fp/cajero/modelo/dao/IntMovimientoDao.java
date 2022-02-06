package es.fp.cajero.modelo.dao;

import java.util.List;

import es.fp.cajero.modelo.beans.Movimiento;

public interface IntMovimientoDao {

	Movimiento findById(int idMovimiento);
	List<Movimiento> findAll();
	int insertOne(Movimiento movimiento);

	
}
