package aplicacionWeb.security;

public class verificacionAcceso {
	PasswordAuthentication PA;
	
	public verificacionAcceso() {
		this.PA = new PasswordAuthentication();
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean verificarPassword(String pass, String hash) {
		
		return this.PA.authenticate(pass, hash);
	}
	
	@SuppressWarnings("deprecation")
	public String generarHash(String s) {
		return PA.hash(s);
	}
}
