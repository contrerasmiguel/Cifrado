package servidor.controlador;

import java.io.IOException;

import javax.swing.SwingUtilities;

import servidor.modelo.*;
import servidor.vista.*;

public class ControladorPrincipal implements Runnable {
	Ventana w;
	Servidor ser;
	Desencriptado des;

	public ControladorPrincipal() {
		w = new Ventana();
		w.setVisible(true);
		
		try {
			ser = new Servidor(Integer.parseInt(w.getPuerto()));
			new Thread(this).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void esperarEntrada() {
		ser.comenzarServidor();
		String mensajeCifrado = ser.getMensajeRecibido();
		w.getaMenEncrip().append(mensajeCifrado + "\n");
		Desencriptado.desencriptar(mensajeCifrado, w.getClave()).ifPresent(mensajeDecifrado -> {			
			w.getaMensaje().append(mensajeDecifrado + "\n");
		});		
	}
	
	@Override
	public void run() {
		while (true) {
			esperarEntrada();
		}
	}
	
}
