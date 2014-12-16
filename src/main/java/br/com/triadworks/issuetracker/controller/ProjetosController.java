package br.com.triadworks.issuetracker.controller;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.triadworks.issuetracker.model.Projeto;

@Resource
public class ProjetosController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjetosController.class);
	
	private final Result result;
	private final ProducerTemplate producer;
	
	private ProjetosController(Result result, ProducerTemplate producer) {
		this.result = result;
		this.producer = producer;
	}

	@Get("/projetos")
	public void form() {
	}
	
	@Post("/projetos")
	public void novo(Projeto projeto) {
		
		projeto.setId(projeto.getDescricao().hashCode());
		logger.info("Gravando projeto {}", projeto);
		
		producer.sendBody("jms:queue:projetos", projeto);
		
		result.include("notice", "Projeto gravado com sucesso!")
			.redirectTo(this).form();
	}
	
}
