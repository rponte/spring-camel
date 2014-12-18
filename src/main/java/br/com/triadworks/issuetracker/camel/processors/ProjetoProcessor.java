package br.com.triadworks.issuetracker.camel.processors;

import java.util.Map;

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
	
	public void processaTexto(String texto) {
		logger.info("Processando TEXTO da fila {}", texto);
	}
	
	public void processaPojo(Projeto projeto) {
		logger.info("Processando POJO da fila {}", projeto);
	}
	
	public void processaMap(Map<String, Object> map) {
		logger.info("Processando MAP da fila {}", map);
	}
	
}
