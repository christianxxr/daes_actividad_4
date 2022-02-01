package es.fp.cajero.modelo.dao;

import java.util.List;

import es.fp.cajero.modelo.beans.Cuenta;

public interface IntCuentaDao {

	Cuenta findById(int idCuenta);
	List<Cuenta> findAll();
	

}
