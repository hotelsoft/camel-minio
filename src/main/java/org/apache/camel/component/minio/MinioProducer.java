package org.apache.camel.component.minio;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Minio producer.
 */
public class MinioProducer extends DefaultProducer {
	private static final Logger LOG = LoggerFactory.getLogger(MinioProducer.class);
	private MinioEndpoint endpoint;

	public MinioProducer(final MinioEndpoint endpoint) {
		super(endpoint);
		this.endpoint = endpoint;
	}

	public void process(Exchange exchange) throws Exception {
		System.out.println(exchange.getIn().getBody());
	}

}
