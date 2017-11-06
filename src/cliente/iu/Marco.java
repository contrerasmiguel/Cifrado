package cliente.iu;

import javax.swing.JFrame;

public class Marco extends JFrame {
	private static final long serialVersionUID = -5876514237203451527L;
	LaminaMarco laminaMarco;
	
	public Marco() {
		setBounds(100,100,280,350);
		laminaMarco=new LaminaMarco();
		add(laminaMarco);
		setVisible(true);
	}
	
	public LaminaMarco getLaminaMarco() {
		return laminaMarco;
	}
}
