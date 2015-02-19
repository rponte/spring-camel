package br.com.triadworks.issuetracker.service;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.triadworks.issuetracker.model.Projeto;

@Service
public class ProjetosService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjetosService.class);

	@EndpointInject(uri="activemq:queue:projetos")
	private ProducerTemplate producer;
	
	public void salva(Projeto projeto) {
		logger.info("Gravando projeto {}", projeto);
		producer.sendBody(projeto.toJson());
	}
	
}
