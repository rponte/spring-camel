package br.com.triadworks.issuetracker.service;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadworks.issuetracker.model.Projeto;

@Service
public class ProjetosService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjetosService.class);

	@Autowired
	private ProducerTemplate producer;
	
	public void salva(Projeto projeto) {
		logger.info("Gravando projeto {}", projeto);
		producer.sendBody("jms:queue:projetos", projeto.toJson());
	}
	
}
