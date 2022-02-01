package es.fp.cajero.model.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.fp.cajero.modelo.beans.Cuenta;
import es.fp.cajero.modelo.beans.Movimiento;
import es.fp.cajero.modelo.dao.IntCuentaDao;
import es.fp.cajero.modelo.dao.IntMovimientoDao;
import es.fp.cajero.modelo.repository.IntCuentaRepository;

@Controller
@RequestMapping("/cuentas")
public class GestionCuentas {

	@Autowired
	IntCuentaDao icuen;
	@Autowired
	IntMovimientoDao imov;
	@Autowired
	IntCuentaRepository crepo;

	@GetMapping("/opciones")
	public String opciones() {
		return "inicioCuentas";
	}

	@GetMapping("/ingresar")
	public String ingresar() {
		return "ingresar";
	}

	@PostMapping("/ingresar")
	public String ingresar(Cuenta cuenta, Movimiento movimiento, @RequestParam("saldo") double saldo,
			HttpSession session, RedirectAttributes rattr) {
		movimiento.setOperacion("Ingreso");
		LocalDate fecha = LocalDate.now();
		movimiento.setFecha(Date.valueOf(fecha));
		movimiento.setCantidad(cuenta.getSaldo());
		int reg = crepo.aumentarSaldo(saldo, cuenta.getIdCuenta());
		Cuenta aux = new Cuenta();
		aux.setIdCuenta(cuenta.getIdCuenta());
		movimiento.setCuenta(aux);
		if (reg == 1) {
			imov.insertOne(movimiento);
			rattr.addFlashAttribute("mensaje", "saldo actualizado");
		} else
			rattr.addFlashAttribute("mensaje", "saldo no actualizado");

		return "redirect:/cuentas/opciones";

	}

	@GetMapping("/verMovimientos")
	public String ver(Model model) {
		model.addAttribute("listaCuentas", icuen.findAll());
		model.addAttribute("listaMovimientos", imov.findAll());
		return "movimientos";
	}

	@GetMapping("/extraer")
	public String extraer() {
		return "extraer";
	}

	@PostMapping("/extraer")
	public String extraer(Cuenta cuenta, Movimiento movimiento, @RequestParam("saldo") double saldo,
			HttpSession session, RedirectAttributes rattr) {
		movimiento.setOperacion("Extracción");
		LocalDate fecha = LocalDate.now();
		movimiento.setFecha(Date.valueOf(fecha));
		movimiento.setCantidad(cuenta.getSaldo());
		Cuenta aux = new Cuenta();
		aux.setIdCuenta(cuenta.getIdCuenta());
		movimiento.setCuenta(aux);
		if (!(movimiento.getCantidad() >= movimiento.getCuenta().getSaldo())) {
			int reg = crepo.disminuirSaldo(saldo, cuenta.getIdCuenta());
			if (reg == 1) {
				imov.insertOne(movimiento);
			}
			rattr.addFlashAttribute("mensaje", "saldo actualizado");
		} else
			rattr.addFlashAttribute("mensaje", "saldo no actualizado/dinero insuficiente");
		return "redirect:/cuentas/opciones";

	}

	@GetMapping("/transferencia")
	public String transferencia(Model model) {
		model.addAttribute("listaCuentas", icuen.findAll());
		return "transferencia";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/transferencia")
	public String transferencia(Cuenta cuenta, Movimiento movimiento, RedirectAttributes rattr, HttpSession session) {

		if (!session.getId().equals(cuenta.getIdCuenta())) {
			movimiento.setOperacion("Abono por transferencia");
			LocalDate fecha = LocalDate.now();
			movimiento.setFecha(Date.valueOf(fecha));
			int reg = imov.insertOne(movimiento);
			if (!(movimiento.getCantidad() >= movimiento.getCuenta().getSaldo())) {
				if (reg == 1) {
					crepo.aumentarSaldo(movimiento.getCantidad(), movimiento.getCuenta().getIdCuenta());
					crepo.disminuirSaldo(movimiento.getCantidad(), cuenta.getIdCuenta());
				}
				rattr.addFlashAttribute("mensaje", "transferencia realizada");
			} else
				rattr.addFlashAttribute("mensaje", "transferencia no realizada. No hay suficiente dinero");
		}
		return "redirect:/cuentas/opciones";

	}

	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "index";
	}

}
