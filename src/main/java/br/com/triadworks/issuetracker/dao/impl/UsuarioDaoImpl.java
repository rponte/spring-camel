package br.com.triadworks.issuetracker.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario buscaPor(String login, String senha) {
		
		if (!login.equals(senha))
			return null;
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		return usuario;
	}

}
