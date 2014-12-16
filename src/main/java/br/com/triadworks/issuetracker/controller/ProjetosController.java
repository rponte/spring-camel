package br.com.triadworks.issuetracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.triadworks.issuetracker.model.Projeto;

@Resource
public class ProjetosController {
	
	private Logger logger = LoggerFactory.getLogger(ProjetosController.class);
	
	private final Result result;
	
	private ProjetosController(Result result) {
		this.result = result;
	}

	@Get("/projetos")
	public void form() {
	}
	
	@Post("/projetos")
	public void novo(Projeto projeto) {
		logger.info("Gravando projeto {}", projeto);
		result.include("notice", "Projeto gravado com sucesso!")
			.redirectTo(this).form();
	}
	
}
