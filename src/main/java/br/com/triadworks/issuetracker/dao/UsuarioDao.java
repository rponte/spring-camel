package br.com.triadworks.issuetracker.dao;

import br.com.triadworks.issuetracker.model.Usuario;

public interface UsuarioDao {

	public Usuario buscaPor(String login, String senha);
	
}
