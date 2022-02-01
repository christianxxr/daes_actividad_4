package es.fp.cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fp.cajero.modelo.beans.Cuenta;
import es.fp.cajero.modelo.repository.IntCuentaRepository;

@Service
public class CuentaDaoImplMy8 implements IntCuentaDao {

	@Autowired
	private IntCuentaRepository crepo;

	@Override
	public Cuenta findById(int idCuenta) {
		// TODO Auto-generated method stub
		return crepo.findById(idCuenta).orElse(null);
	}

	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}
	
	


}
