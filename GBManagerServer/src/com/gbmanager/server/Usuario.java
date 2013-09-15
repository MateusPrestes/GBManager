package com.gbmanager.server;

public class Usuario {


	String login;
	String senha;
	Long id;

	
	public Usuario(String login, String senha){
		this.login = login;
		this.senha = login;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
