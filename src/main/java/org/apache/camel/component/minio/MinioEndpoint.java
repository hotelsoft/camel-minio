package org.apache.camel.component.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.ScheduledPollEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a Minio endpoint.
 */
@UriEndpoint(firstVersion = "2.19.0", scheme = "minio", title = "Minio", syntax = "minio:url", consumerClass = MinioConsumer.class, label = "storage,cloud,file")
public class MinioEndpoint extends ScheduledPollEndpoint {
	private static final Logger LOG = LoggerFactory.getLogger(MinioEndpoint.class);

	@UriPath
	@Metadata(required = "true")
	private String name;
	@UriPath(description = "Bucket name or ARN")
	@Metadata(required = "true")
	private String bucketNameOrArn;
	@UriParam
	private MinioConfiguration configuration;

	public MinioEndpoint() {
	}

	public MinioEndpoint(final String uri, final String remaining, final MinioComponent component,
			final MinioConfiguration configuration) {
		super(uri, component);
		this.configuration = configuration;
	}

	public Producer createProducer() throws Exception {
		return new MinioProducer(this);
	}

	public Consumer createConsumer(Processor processor) throws Exception {
		return new MinioConsumer(this, processor);
	}

	public boolean isSingleton() {
		return true;
	}

	/**
	 * Some description of this option, and what it does
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private MinioClient createClient() throws InvalidPortException, InvalidEndpointException {
		final MinioClient minioClient = new MinioClient("https://play.minio.io:9000", this.configuration.getAccessKey(),
				this.configuration.getSecretKey());
		return minioClient;

	}

}
