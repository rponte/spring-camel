package br.com.triadworks.issuetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadworks.issuetracker.dao.UsuarioDao;
import br.com.triadworks.issuetracker.model.Usuario;

@Service
public class AutenticadorImpl implements Autenticador {

	private final UsuarioDao dao;
	
	@Autowired
	private AutenticadorImpl(UsuarioDao dao) {
		this.dao = dao;
	}

	@Override
	public Usuario autentica(String login, String senha) {
		return dao.buscaPor(login, senha);
	}

}



