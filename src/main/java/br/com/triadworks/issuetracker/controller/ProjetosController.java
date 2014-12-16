package br.com.triadworks.issuetracker.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.triadworks.issuetracker.model.Projeto;
import br.com.triadworks.issuetracker.service.ProjetosService;

@Resource
public class ProjetosController {
	
	private final Result result;
	private final ProjetosService service;
	
	private ProjetosController(Result result, ProjetosService service) {
		this.result = result;
		this.service = service;
	}

	@Get("/projetos")
	public void form() {
	}
	
	@Post("/projetos")
	public void novo(Projeto projeto) {
		
		projeto.setId(projeto.getDescricao().hashCode());
		service.salva(projeto);
		
		result.include("notice", "Projeto gravado com sucesso!")
			.redirectTo(this).form();
	}
	
}
