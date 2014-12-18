package br.com.triadworks.issuetracker.camel.routes.aws;

import java.util.Random;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.camel.processors.ProjetoProcessor;
import br.com.triadworks.issuetracker.model.Projeto;

@Component
public class AwsSQSRouter extends RouteBuilder {

	@Autowired
	private ProjetoProcessor processor;
	
	private final Random randomGenerator = new Random();
	
	@Override
	public void configure() throws Exception {
		
		String sqs = "aws-sqs://projetos?amazonSQSClient=#awsSqsClient&defaultVisibilityTimeout=2";
		
		/**
		 * Produz uma mensagem a cada 10s
		 */
		from("timer:kickoff?period=10s")
			.setBody().method(this, "generateJson")
			.to(sqs);
		
		/**
		 * Consome fila do SQS
		 */
		from(sqs)
			.bean(this.processor, "processaTexto");
		
	}
	
	public String generateJson() {
		
		int id = randomGenerator.nextInt(Integer.MAX_VALUE);
		String descricao = ("Projeto #" + id);
		
		Projeto projeto = new Projeto(id, descricao);
		return projeto.toJson();
	}
	
}
