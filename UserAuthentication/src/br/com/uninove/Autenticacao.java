package br.com.uninove;

public class Autenticacao {
	
	private String usuario, senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean autenticar(){
		
		//criar um m�todo de consulta com banco de dados login - usu�rio e senha.
		
		if(usuario.equalsIgnoreCase("rafael") && senha.equals("123")){
			return true;
		}else{
			return false;
		}
	}

}
