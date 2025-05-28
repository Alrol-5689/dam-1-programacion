package box;

import java.util.ArrayList;

import Excepciones.CorreoInvalidoException;
import Excepciones.CorreoUsadoException;
import Excepciones.DniInvalidoException;
import Excepciones.DniUsadoException;
import Excepciones.NikUsadoException;
import Excepciones.PinInvalidoException;
import Excepciones.TelefonoInvalidoException;
import Excepciones.TelefonoUsadoException;

public class Validador {
	
	public Validador() {
	}

	public void validarDni(String dni) throws DniInvalidoException {
		if (!dni.matches("\\d{8}[A-Za-z]")) {
			throw new DniInvalidoException("formato incorrecto.");
		}
	}

	public void dniUnico(ArrayList<CuentaUsuario> lista, String dni) throws DniUsadoException {
		for (CuentaUsuario a : lista) {
			if (a.getDni().equalsIgnoreCase(dni)) {
				throw new DniUsadoException("el dni " + dni + " ya se encuentra en el sistema.");
			}
		}
	}
	public void nikUnico(ArrayList<CuentaUsuario> lista, String nik) throws NikUsadoException{
		for (CuentaUsuario a : lista) {
			if (a.getNik().equalsIgnoreCase(nik)) {
				throw new NikUsadoException("el nik " + nik + " ya se está en uso.");
			}
		}
	}

	public void validarTelefono(int telefono) throws TelefonoInvalidoException {
		int longitud = String.valueOf(telefono).length(); // Convierte el número a String y cuenta los dígitos
		if (longitud != 9) {
			throw new TelefonoInvalidoException("el teléfono debe contener 9 dígitos.");
		}
	}

	public void tlfUnico(ArrayList<CuentaUsuario> lista, int tlf) throws TelefonoUsadoException {
		for (CuentaUsuario c : lista) {
			if (c.getTelefono() == tlf) {
				throw new TelefonoUsadoException("el teléfono " + tlf + " ya se encuentra en el sistema.");
			}
		}
		
	}
	
//	public void validarPin(int pin) throws PinInvalidoException{
//		String dinX = String.valueOf(pin);
//		int longitud = dinX.length();
//		if(longitud < 4 || longitud > 4) {
//			throw new PinInvalidoException("el PIN debe tener 4 dígitos.");
//		}
//	}
	public void validarPin(String pin) throws PinInvalidoException {
	    if (pin == null || !pin.matches("\\d{4}")) {
	        throw new PinInvalidoException("el PIN debe tener 4 dígitos.");
	    }
	}
	public void validarCorreo(String correo) throws CorreoInvalidoException {
        if (correo == null || correo.isBlank()) {
        	throw new CorreoInvalidoException("debes introducir un correo electrónico.");
        }
        String norma = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        if(!correo.matches(norma)) {
        	throw new CorreoInvalidoException("debes introducir un correo electrónico válido.");
        }
    }
	public void correoUnico(ArrayList<CuentaUsuario> lista, String correo) throws CorreoUsadoException{
		for (CuentaUsuario c : lista) {
			if (c.getEmail().equalsIgnoreCase(correo)) {
				throw new CorreoUsadoException("el teléfono " + correo + " ya se encuentra en el sistema.");
			}
		}
	}
	


}
