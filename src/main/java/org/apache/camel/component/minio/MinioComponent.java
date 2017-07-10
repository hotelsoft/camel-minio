package org.apache.camel.component.minio;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultComponent;

import java.util.Map;

/**
 * Represents the component that manages {@link MinioEndpoint}.
 */
public class MinioComponent extends DefaultComponent {

	public MinioComponent() {
		super();
	}

	public MinioComponent(CamelContext context) {
		super(context);
	}

	@Override
	protected MinioEndpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters)
			throws Exception {
		final MinioConfiguration configuration = new MinioConfiguration();
		setProperties(configuration, parameters);
		if (remaining == null || remaining.trim().length() == 0) {
			throw new IllegalArgumentException("Bucket name must be specified.");
		}
		if (remaining.startsWith("arn:")) {
			remaining = remaining.substring(remaining.lastIndexOf(":") + 1, remaining.length());
		}
		configuration.setBucketName(remaining);

		final MinioEndpoint endpoint = new MinioEndpoint(uri, remaining, this, configuration);
		setProperties(endpoint, parameters);
		return endpoint;
	}
}
