package cliente.iu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LaminaMarco extends JPanel implements ActionListener, DocumentListener {
	static final long serialVersionUID = -1597661653132009882L;
	JTextField tfMensaje, tfDireccionIp, tfPuerto;
	JPasswordField pfClave;
	JButton btnEnviar;
	ArrayList<LaminaMarcoListener> listeners;

	public LaminaMarco() {
		listeners = new ArrayList<LaminaMarcoListener>();
		
		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setForeground(Color.WHITE);
		add(lblMensaje);
		tfMensaje = new JTextField(20);
		tfMensaje.getDocument().addDocumentListener(this);
		add(tfMensaje);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setForeground(Color.WHITE);
		add(lblClave);
		pfClave = new JPasswordField(20);
		pfClave.getDocument().addDocumentListener(this);
		add(pfClave);
		
		JLabel lblDireccionIp = new JLabel("Dirección IP");
		lblDireccionIp.setForeground(Color.WHITE);
		add(lblDireccionIp);
		tfDireccionIp = new JTextField(20);
		tfDireccionIp.getDocument().addDocumentListener(this);
		add(tfDireccionIp);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setForeground(Color.WHITE);
		add(lblPuerto);
		tfPuerto = new JTextField(20);
		tfPuerto.getDocument().addDocumentListener(this);
		add(tfPuerto);
		
		btnEnviar = new JButton(new ImageIcon(getClass().getResource("/imagenes/encriptar.png")));
		btnEnviar.setSize(150, 50);
		btnEnviar.addActionListener(this);
		add(btnEnviar);
		setBackground(Color.BLACK);
	}
	
	public void mostrarError(String mensajeError) {
		JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listeners.forEach(listener -> {
			listener.alPresionarBotonEnviar();
		});
	}

	public ArrayList<LaminaMarcoListener> getListeners() {
		return listeners;
	}

	public JTextField getTfPuerto() {
		return tfPuerto;
	}

	public void setTfPuerto(JTextField tfPuerto) {
		this.tfPuerto = tfPuerto;
	}

	public JTextField getTfMensaje() {
		return tfMensaje;
	}

	public JTextField getTfDireccionIp() {
		return tfDireccionIp;
	}

	public JPasswordField getPfClave() {
		return pfClave;
	}

	@Override
	public void changedUpdate(DocumentEvent e) { }

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == tfMensaje.getDocument()) {
			listeners.forEach(l -> l.alCambiarMensaje());
		}
		else if (e.getDocument() == pfClave.getDocument()) {
			listeners.forEach(l -> l.alCambiarClave());
		}
		else if (e.getDocument() == tfDireccionIp.getDocument()) {
			listeners.forEach(l -> l.alCambiarDireccionIp());
		}
		else if (e.getDocument() == tfPuerto.getDocument()) {
			listeners.forEach(l -> l.alCambiarPuerto());
		}		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (e.getDocument() == tfMensaje.getDocument()) {
			listeners.forEach(l -> l.alCambiarMensaje());
		}
		else if (e.getDocument() == pfClave.getDocument()) {
			listeners.forEach(l -> l.alCambiarClave());
		}
		else if (e.getDocument() == tfDireccionIp.getDocument()) {
			listeners.forEach(l -> l.alCambiarDireccionIp());
		}
		else if (e.getDocument() == tfPuerto.getDocument()) {
			listeners.forEach(l -> l.alCambiarPuerto());
		}		
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
}
