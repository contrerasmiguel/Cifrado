package cliente.modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Envio {
	Socket socket;
	Datos datos;
	ArrayList<EnvioListener> listeners;

	public Envio(Datos datos) {
		this.datos = datos;
		listeners = new ArrayList<EnvioListener>();
	}
	
	public boolean conectar() {
		try {
			if (socket != null) {
				socket.close();
			}
			socket = new Socket(datos.getDireccionIp(), Integer.parseInt(datos.getPuerto()));
		} catch (NumberFormatException | IOException e) {
			return false;
		}
		return true;
	}
	
	public void enviar(String mensaje) {
		if (socket != null) {
			try {
				DataOutputStream flujoDatosSalida = new DataOutputStream(socket.getOutputStream());
				flujoDatosSalida.writeUTF(mensaje);
				flujoDatosSalida.close();
			} catch (IOException e) {
				listeners.forEach(listener -> {
					listener.enErrorAlEnviar();
				});
			}			
		}
	}

	public ArrayList<EnvioListener> getListeners() {
		return listeners;
	}
}
