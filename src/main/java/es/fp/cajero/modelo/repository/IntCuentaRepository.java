package es.fp.cajero.modelo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import es.fp.cajero.modelo.beans.Cuenta;

public interface IntCuentaRepository extends JpaRepository<Cuenta, Integer> {

	@Transactional
	@Modifying
	@Query("update Cuenta c set c.saldo = c.saldo + ?1 where c.idCuenta = ?2")
	public int aumentarSaldo(double saldo, int id);

	@Transactional
	@Modifying
	@Query("update Cuenta c set c.saldo = c.saldo - ?1 where c.idCuenta = ?2")
	public int disminuirSaldo(double saldo, int id);

}
