package br.com.triadworks.issuetracker.camel.routes.aws;

import org.apache.camel.LoggingLevel;
import org.apache.camel.processor.interceptor.DefaultTraceFormatter;
import org.apache.camel.processor.interceptor.TraceFormatter;
import org.apache.camel.processor.interceptor.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TracerFactory {

	@Bean
	public Tracer camelTracer() {
		Tracer tracer = new Tracer();
		tracer.setEnabled(true);
		tracer.setTraceExceptions(true);
		tracer.setTraceInterceptors(true);
		tracer.setTraceOutExchanges(false);
		tracer.setLogLevel(LoggingLevel.WARN);
		tracer.setFormatter(formatter());
		tracer.setTraceInterceptors(true);
		return tracer;
	}

	private TraceFormatter formatter() {
		DefaultTraceFormatter formatter = new DefaultTraceFormatter();
		formatter.setShowExchangeId(false);
		formatter.setShowBreadCrumb(false);
		formatter.setShowRouteId(true);
		return formatter;
	}
}
