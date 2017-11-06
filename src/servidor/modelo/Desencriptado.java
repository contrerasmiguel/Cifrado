package servidor.modelo;

import java.util.Optional;
import cifrado.TripleDES;

public class Desencriptado {
	
	public static Optional<String> desencriptar(String mensaje, String clave) {
		TripleDES td = new TripleDES(clave);
		return td.decifrar(mensaje);
	}
}
