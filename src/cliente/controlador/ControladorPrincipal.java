package cliente.controlador;

import cifrado.TripleDES;
import cliente.iu.LaminaMarco;
import cliente.iu.LaminaMarcoListener;
import cliente.modelo.Datos;
import cliente.modelo.Envio;
import cliente.modelo.EnvioListener;

public class ControladorPrincipal implements LaminaMarcoListener, EnvioListener {
	
	Datos datos;
	Envio envio;
	LaminaMarco laminaMarco;
	
	public ControladorPrincipal(LaminaMarco laminaMarco) {
		this.datos = new Datos();
		this.envio = new Envio(datos);
		envio.getListeners().add(this);
		this.laminaMarco = laminaMarco;
		
		this.laminaMarco.getTfMensaje().setText(datos.getMensaje());
		this.laminaMarco.getPfClave().setText(datos.getClave());
		this.laminaMarco.getTfDireccionIp().setText(datos.getDireccionIp());
		this.laminaMarco.getTfPuerto().setText(datos.getPuerto());
	}

	@Override
	public void alPresionarBotonEnviar() {
		if (datos.getClave().length() == 0) {
			laminaMarco.mostrarError("Debe suministrar una clave de encriptado.");
		}
//		else if (datos.getClave().length() > Encriptado.LONGITUD_MAXIMA_CLAVE) {
//			laminaMarco.mostrarError("La clave no debe superar " + Encriptado.LONGITUD_MAXIMA_CLAVE + " caracteres de longitud.");
//		}
		else if (datos.getDireccionIp().length() == 0) {
			laminaMarco.mostrarError("Debe suministrar la dirección IP del servidor.");
		}
		else if (datos.getPuerto().length() == 0) {
			laminaMarco.mostrarError("Debe suministrar el puerto del servidor.");
		}
		else {
			if (envio.conectar()) {
				TripleDES td = new TripleDES(datos.getClave());
				td.cifrar(datos.getMensaje()).ifPresent(mensajeCifrado -> {
					envio.enviar(mensajeCifrado);
					laminaMarco.mostrarMensaje("Se envió el mensaje correctamente.");
				});
			}
			else {
				laminaMarco.mostrarError("El cliente no se logró conectar al servidor.");
			}
		}
	}

	@Override
	public void alCambiarMensaje() {
//		String nuevoMensaje = laminaMarco.getTfMensaje().getText();
//		
//		if (nuevoMensaje.length() > Encriptado.LONGITUD_MAXIMA_MENSAJE) {
//			laminaMarco.mostrarError("El mensaje no debe superar " + Encriptado.LONGITUD_MAXIMA_MENSAJE + " caracteres de longitud.");
//			SwingUtilities.invokeLater((new Runnable() {
//				@Override
//				public void run() {
//					laminaMarco.getTfMensaje().setText(nuevoMensaje.substring(0, Math.min(nuevoMensaje.length(), Encriptado.LONGITUD_MAXIMA_MENSAJE)));
//				}
//			}));
//		}
//		else {
//			datos.setMensaje(nuevoMensaje);
//		}
		datos.setMensaje(laminaMarco.getTfMensaje().getText());
	}

	@Override
	public void alCambiarClave() {
//		String nuevaClave = String.valueOf(laminaMarco.getPfClave().getPassword());
//		
//		if (nuevaClave.length() > Encriptado.LONGITUD_MAXIMA_CLAVE) {
//			laminaMarco.mostrarError("La clave no debe superar " + Encriptado.LONGITUD_MAXIMA_CLAVE + " caracteres de longitud.");
//			SwingUtilities.invokeLater((new Runnable() {
//				@Override
//				public void run() {
//					laminaMarco.getPfClave().setText(nuevaClave.substring(0, Math.min(nuevaClave.length(), Encriptado.LONGITUD_MAXIMA_CLAVE)));
//				}
//			}));
//		}
//		else {
//			datos.setClave(nuevaClave);
//		}
		datos.setClave(String.valueOf(laminaMarco.getPfClave().getPassword()));
	}

	@Override
	public void alCambiarDireccionIp() {
		datos.setDireccionIp(laminaMarco.getTfDireccionIp().getText());
		
	}

	@Override
	public void alCambiarPuerto() {
		datos.setPuerto(laminaMarco.getTfPuerto().getText());
	}

	@Override
	public void enErrorAlEnviar() {
		laminaMarco.mostrarError("Ocurrió un error al enviar el mensaje al servidor.");
	}

}
