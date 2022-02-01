package es.fp.cajero.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name = "cuentas")
@NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cuenta")
	private int idCuenta;

	private double saldo;

	@Column(name = "tipo_cuenta")
	private String tipoCuenta;

	public Cuenta() {
	}

	public Cuenta(int idCuenta, double saldo, String tipoCuenta) {
		super();
		this.idCuenta = idCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}

	public int getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCuenta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cuenta))
			return false;
		Cuenta other = (Cuenta) obj;
		if (idCuenta != other.idCuenta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", saldo=" + saldo + ", tipoCuenta=" + tipoCuenta + "]";
	}

}