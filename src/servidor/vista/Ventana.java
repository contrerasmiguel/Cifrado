package servidor.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lPuerto, lClave, lMenEnc, lMenDesenc;
	private JTextField tPuerto;
	private JPasswordField pClave;
	private JTextArea aMensaje, aMenEncrip;
	
	public Ventana() {
		setTitle("SERVIDOR");
        setSize(260, 420);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        
        lPuerto = new JLabel("Puerto:");
        lPuerto.setForeground(Color.WHITE);
        lPuerto.setBounds(10,10,100,16);
        
        lClave = new JLabel("Clave:");
        lClave.setForeground(Color.WHITE);
        lClave.setBounds(16,38,100,16);
        
        lMenEnc = new JLabel("Mensaje Encriptado:");
        lMenEnc.setForeground(Color.WHITE);
        lMenEnc.setBounds(20,70,120,16);
        
        lMenDesenc = new JLabel("Mensaje Desencriptado:");
        lMenDesenc.setForeground(Color.WHITE);
        lMenDesenc.setBounds(20,205,150,16);
        
        tPuerto = new JTextField("7007");
        tPuerto.setBounds(60,10,160,16);
        
        pClave = new JPasswordField("123456");
        pClave.setBounds(60,38,160,16);
        
        aMensaje = new JTextArea();
        aMensaje.setEditable(false);
        aMensaje.setLineWrap(true);
        
        aMenEncrip = new JTextArea();
        aMenEncrip.setEditable(false);
        aMenEncrip.setLineWrap(true);
               
        add(lPuerto);
        add(lClave);
        add(lMenEnc);
        add(lMenDesenc);
        add(tPuerto);
        add(pClave);
        
        JScrollPane scrollMensaje = new JScrollPane(aMensaje, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollMensaje.setBounds(20,225,215,100);
        
        JScrollPane scrollMenEncrip = new JScrollPane(aMenEncrip, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollMenEncrip.setBounds(20,90,215,100);
        
        add(scrollMensaje);
        add(scrollMenEncrip);
	}
	
	public String getClave() {
		return String.valueOf(pClave.getPassword());
	}
	
	public String getPuerto() {
		return tPuerto.getText();
	}

	public JTextArea getaMensaje() {
		return aMensaje;
	}

	public JTextArea getaMenEncrip() {
		return aMenEncrip;
	}

}
