package com.lp3.gbmanager.model;

import java.util.List;

public interface RepositorioUsuario {
	
	public boolean salvar(Usuario usuario);
	public boolean deletar(Usuario usuario);
	public Usuario getUsuario(Long id);
	public List<Usuario> listarUsuario();
	public Usuario buscaUsuario(String nome);

}
