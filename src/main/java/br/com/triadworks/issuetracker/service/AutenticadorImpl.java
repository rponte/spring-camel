package br.com.triadworks.issuetracker.service;

import org.springframework.stereotype.Service;

import br.com.triadworks.issuetracker.model.Usuario;

@Service("autenticador")
public class AutenticadorImpl implements Autenticador {

	@Override
	public Usuario autentica(String login, String senha) {
		if (login.equals(senha)) {
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			return usuario;
		}
		return null;
	}

}



