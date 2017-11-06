package cifrado;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class TripleDES {
	private final String claveSecreta;

	public TripleDES(String claveSecreta) {
		this.claveSecreta = claveSecreta;
	}
	
	public Optional<String> cifrar(String texto) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digestionClave = md.digest(claveSecreta.getBytes("utf-8"));
			byte[] bytesClave = Arrays.copyOf(digestionClave, 24);
		
			SecretKey key = new SecretKeySpec(bytesClave, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			byte[] bytesTextoPlano = texto.getBytes("utf-8");
			byte[] buf = cipher.doFinal(bytesTextoPlano);
			byte[] bytesBase64 = Base64.encodeBase64(buf);
			return Optional.of(new String(bytesBase64));
		}
		catch (Exception ex) {
			return Optional.empty();
		}
	}
	
	public Optional<String> decifrar(String textoEncriptado) {
		try {
			byte[] mensaje = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
			
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digestionClave = md.digest(claveSecreta.getBytes("utf-8"));
			byte[] bytesClave = Arrays.copyOf(digestionClave, 24);
			SecretKey key = new SecretKeySpec(bytesClave, "DESede");
			
			Cipher decipher = Cipher.getInstance("DESede");
			decipher.init(Cipher.DECRYPT_MODE, key);
			
			byte[] textoPlano = decipher.doFinal(mensaje);
			
			return Optional.of(new String(textoPlano, "UTF-8"));
		}
		catch (Exception ex) {
			return Optional.empty();
		}
	}
}
