package br.com.triadworks.issuetracker.camel.routes.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

@Component
public class AwsSQSClientFactory {
	
	@Value("${aws.accessKey}")
	private String accessKey;
	
	@Value("${aws.secretKey}")
	private String secretKey;
	
	@Value("${aws.sqs.endpoint}")
	private String endpoint;
	
	@Bean
	public AmazonSQS awsSqsClient() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		AmazonSQS client = new AmazonSQSClient(awsCredentials);
		client.setEndpoint(endpoint);
		return client;
	}
	
}
