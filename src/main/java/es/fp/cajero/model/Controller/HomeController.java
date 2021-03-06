package es.fp.cajero.model.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.fp.cajero.modelo.beans.Cuenta;
import es.fp.cajero.modelo.dao.IntCuentaDao;

@Controller
public class HomeController {

	@Autowired
	IntCuentaDao icuen;

	/*
	 * Método que nos muestra el jsp con el index
	 */
	@GetMapping("/inicio")
	public String inicio() {
		return "index";
	}

	/*
	 * Método que nos permite entrar a la siguiente "pantalla" si la cuenta existe.
	 * En caso de que exista, nos guardamos el atributo de sesión
	 */

	@PostMapping("/inicio")
	public String inicio(Model model, HttpSession session, Cuenta cuenta) {
		Cuenta aux = (icuen.findById(cuenta.getIdCuenta()));
		if (aux != null) {
			session.setAttribute("usuario", aux);
			return "redirect:/cuentas/opciones";
		} else {
			model.addAttribute("mensaje", "La cuenta no ha sido encontrada");
			return "index";
		}
	}

}
