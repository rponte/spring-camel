package br.com.triadworks.issuetracker.camel.processors;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.model.Projeto;

@Component
public class ProjetoProcessor {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjetoProcessor.class);

	public void processa(Exchange exchange) {
		Projeto projeto = exchange.getIn().getBody(Projeto.class);
		logger.info("Processando projeto da fila {}", projeto);
	}
	
	public void processaProjeto(Projeto projeto) {
		logger.info("Processando projeto da fila {}", projeto);
	}
	
}
