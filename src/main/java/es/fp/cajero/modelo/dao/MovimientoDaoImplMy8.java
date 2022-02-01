package es.fp.cajero.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fp.cajero.modelo.beans.Movimiento;
import es.fp.cajero.modelo.repository.IntMovimientosRepository;
@Service
public class MovimientoDaoImplMy8 implements IntMovimientoDao{

	@Autowired
	IntMovimientosRepository mrepo;
	
	@Override
	public Movimiento findById(int idMovimiento) {
		// TODO Auto-generated method stub
		return mrepo.findById(idMovimiento).orElse(null);
	}

	@Override
	public List<Movimiento> findAll() {
		// TODO Auto-generated method stub
		return mrepo.findAll();
	}

	@Override
	public int insertOne(Movimiento movimiento) {
		// TODO Auto-generated method stub
		int filas = 0;
		try {
			mrepo.save(movimiento);
			filas = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int deleteOne(int idMovimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Movimiento> findByCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}
