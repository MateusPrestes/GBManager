package com.gbmanager.server;

import java.util.HashMap;
import java.util.Map;

public class RepositorioUsuario {
	
	private static RepositorioUsuario instance;
	private static Map<Long, Usuario> usuarios;
	
	private RepositorioUsuario(){}
	
	public static RepositorioUsuario getInstance(){
		if(RepositorioUsuario.instance == null){
			RepositorioUsuario.instance = new RepositorioUsuario();
			loadDB();
		}
		return RepositorioUsuario.instance;
		
	}
	
	public Map<Long,Usuario> getRepositorioUsuario(){
		return usuarios;
		
	}
	
	public static void loadDB(){
		usuarios = new HashMap<Long, Usuario>();
		Usuario user1 = new Usuario("adm", "123");
		user1.setId(10L);
		usuarios.put(user1.getId(), user1);
		Usuario user2 = new Usuario("gb", "123");
		user2.setId(11L);
		usuarios.put(user2.getId(), user2);
		
	}
	
	

}
