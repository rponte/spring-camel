package br.com.triadworks.issuetracker.camel.routes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GeradorDeConteudoRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("timer:kickoff?period=60s")
			.setBody().method(this, "criaNovoProjetoFake")
			.to("activemq:queue:projetos?jmsMessageType=Map");
		
	}
	
	public Object criaNovoProjetoFake() {
		
		Random randomGenerator = new Random();
		int id = randomGenerator.nextInt(Integer.MAX_VALUE);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("CODIGO", id);
		map.put("DESCRICAO", "Projeto #" + id);
		
		return map;
	}
}
