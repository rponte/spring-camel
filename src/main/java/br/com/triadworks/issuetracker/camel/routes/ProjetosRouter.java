package br.com.triadworks.issuetracker.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.camel.processors.ProjetoProcessor;

@Component
public class ProjetosRouter extends RouteBuilder {

	@Autowired
	private ProjetoProcessor processor;
	
	@Override
	public void configure() throws Exception {
		
		from("jms:queue:projetos")
			.log("Recebendo mensagem da fila #projetos...")
			.bean(this.processor, "processaProjeto");
		
	}

}