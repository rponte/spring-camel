package br.com.triadworks.issuetracker.camel.routes.aws;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

@Component
public class AwsSQSClientFactory {

	@Bean
	public AmazonSQS awsSqsClient() {
		AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAIUHAJEWARDHQ6KZA", " +fVSlyO4YPyQSUrGRm6ORpuv5P5VMCWHs3Iqb3b9");
		AmazonSQS client = new AmazonSQSClient(awsCredentials);
		return client;
	}
	
}
