package br.com.triadworks.issuetracker.camel.routes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import br.com.triadworks.issuetracker.model.Projeto;

//@Component
public class GeradorDeConteudoRouter extends RouteBuilder {
	
	private final Random randomGenerator = new Random();

	@Override
	public void configure() throws Exception {
		
		/**
		 * Dispara uma mensagem para fila a cada 10s
		 */
		from("timer:kickoff?period=10s")
			.setBody().method(this, "criaNovoProjetoFake")
			.to("activemq:queue:projetos");
		
	}
	
	public Object criaNovoProjetoFake() {
		
		int id = randomGenerator.nextInt(Integer.MAX_VALUE);
		String descricao = ("Projeto #" + id);
		
		/**
		 * Retorna Map
		 */
		if ((id % 2) == 0) {
			Map<String, Object> map = new HashMap<>();
			map.put("CODIGO", id);
			map.put("DESCRICAO", descricao);
			return map;
		}
		
		/**
		 * Retorna Json (String)
		 */
		return new Projeto(id, descricao).toJson();
		
	}
}
