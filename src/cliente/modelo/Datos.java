package cliente.modelo;

public class Datos {
	String mensaje, clave, direccionIp, puerto;
	
	public Datos() {
		mensaje = "Mensaje de prueba";
		clave = "123456";
		direccionIp = "localhost";
		puerto = "7007";
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getDireccionIp() {
		return direccionIp;
	}
	
	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}
	
	public String getPuerto() {
		return puerto;
	}
	
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
}
