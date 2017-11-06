package servidor.modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaServidor, salidaCliente;
    
    public Conexion(int p) throws IOException
    {
            ss = new ServerSocket(p);
            cs = new Socket();
    }

}
