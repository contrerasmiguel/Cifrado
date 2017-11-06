package cliente;

import javax.swing.JFrame;

import cliente.controlador.ControladorPrincipal;
import cliente.iu.Marco;

public class Cliente {

	public static void main(String[] args) {
		Marco mimarco = new Marco();
		mimarco.setTitle("CLIENTE");
			
		ControladorPrincipal controlador = new ControladorPrincipal(mimarco.getLaminaMarco());
		mimarco.getLaminaMarco().getListeners().add(controlador);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
