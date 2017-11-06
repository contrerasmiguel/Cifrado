package servidor.modelo;
 
import java.io.DataInputStream;
import java.io.IOException;
 
public class Servidor extends Conexion{
    private String mensajeRecibido;
    
    public Servidor(int p) throws IOException{super(p);}
 
    public void comenzarServidor() {
        try {
            cs = ss.accept();
            DataInputStream flujoEntrada = new DataInputStream(cs.getInputStream());
            mensajeRecibido = flujoEntrada.readUTF();
            cs.close();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }
   
    public String getMensajeRecibido() {
        return mensajeRecibido;
    }
 
}
