package br.com.triadworks.issuetracker.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.camel.processors.ProjetoProcessor;
import br.com.triadworks.issuetracker.model.Projeto;

@Component
public class ProjetosRouter extends RouteBuilder {

	@Autowired
	private ProjetoProcessor processor;
	
	@Override
	public void configure() throws Exception {
		
		DataFormat json = new GsonDataFormat(Projeto.class);
		
		from("activemq:queue:projetos")
			.log("Recebendo mensagem da fila #projetos: ${body}")
//			.unmarshal(json)
			.bean(this.processor, "processaMapaDeProjeto");
		
	}

}