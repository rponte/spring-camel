package br.com.triadworks.issuetracker.camel.routes.aws;

import java.util.Random;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.interceptor.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.camel.processors.ProjetoProcessor;
import br.com.triadworks.issuetracker.model.Projeto;

@Component
public class AwsSQSRouter extends RouteBuilder {

	@Autowired
	private ProjetoProcessor processor;
	
	@Autowired
	private Tracer tracer;
	
	private final Random randomGenerator = new Random();
	
	@Override
	public void configure() throws Exception {
		
		getContext().setTracing(true);
		getContext().addInterceptStrategy(tracer);
		
		String sqs = "aws-sqs://projetos?amazonSQSClient=#awsSqsClient";
		
		/**
		 * Produz uma mensagem a cada 10s
		 */
		from("timer:kickoff?period=5s")
			.setBody().method(this, "generateJson")
			.to(sqs);
		
		/**
		 * Consome fila do SQS
		 */
		
		sqs +=	"&defaultVisibilityTimeout=2" + // esconde msg na fila por 2s
				"&waitTimeSeconds=20" + // habilita long polling por 20s
				"&maxMessagesPerPoll=10" + // recupera 10 mensagens de uma vez
				"&initialDelay=20000" + // 20s
				"&delay=60000" + // 1min
				"&runLoggingLevel=WARN" +
				"";
		
		from(sqs)
			.id("aws.sqs-route")
			.bean(this.processor, "processaTexto");
		
	}
	
	public String generateJson() {
		
		int id = randomGenerator.nextInt(Integer.MAX_VALUE);
		String descricao = ("Projeto #" + id);
		
		Projeto projeto = new Projeto(id, descricao);
		return projeto.toJson();
	}
	
}
