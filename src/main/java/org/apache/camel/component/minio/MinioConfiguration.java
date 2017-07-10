package org.apache.camel.component.minio;

import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class MinioConfiguration implements Cloneable {

	@UriParam(defaultValue = "false")
	boolean secure;
	private String bucketName;
	@UriParam
	private String accessKey;
	@UriParam
	private String secretKey;
	@UriParam(label = "consumer")
	private String fileName;
	@UriParam(label = "consumer")
	private String prefix;
	@UriParam(label = "producer")
	private String region;
	@UriParam(label = "consumer", defaultValue = "true")
	private boolean deleteAfterRead = true;
	@UriParam(label = "producer")
	private boolean deleteAfterWrite;
	@UriParam(label = "producer")
	private boolean multiPartUpload;
	@UriParam(label = "producer", defaultValue = "" + 25 * 1024 * 1024)
	private long partSize = 25 * 1024 * 1024;
	@UriParam
	private String policy;
	@UriParam(label = "producer")
	private String storageClass;
	@UriParam(label = "producer")
	private String serverSideEncryption;
	@UriParam(label = "consumer", defaultValue = "true")
	private boolean includeBody = true;
	@UriParam
	private boolean pathStyleAccess;
	@UriParam(label = "producer", enums = "copyObject,deleteBucket,listBuckets")
	private MinioOperations operation;
	@UriParam(label = "consumer", defaultValue = "true")
	private boolean autocloseBody = true;

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public boolean isDeleteAfterRead() {
		return deleteAfterRead;
	}

	public void setDeleteAfterRead(boolean deleteAfterRead) {
		this.deleteAfterRead = deleteAfterRead;
	}

	public boolean isDeleteAfterWrite() {
		return deleteAfterWrite;
	}

	public void setDeleteAfterWrite(boolean deleteAfterWrite) {
		this.deleteAfterWrite = deleteAfterWrite;
	}

	public boolean isMultiPartUpload() {
		return multiPartUpload;
	}

	public void setMultiPartUpload(boolean multiPartUpload) {
		this.multiPartUpload = multiPartUpload;
	}

	public long getPartSize() {
		return partSize;
	}

	public void setPartSize(long partSize) {
		this.partSize = partSize;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getStorageClass() {
		return storageClass;
	}

	public void setStorageClass(String storageClass) {
		this.storageClass = storageClass;
	}

	public String getServerSideEncryption() {
		return serverSideEncryption;
	}

	public void setServerSideEncryption(String serverSideEncryption) {
		this.serverSideEncryption = serverSideEncryption;
	}

	public boolean isIncludeBody() {
		return includeBody;
	}

	public void setIncludeBody(boolean includeBody) {
		this.includeBody = includeBody;
	}

	public boolean isPathStyleAccess() {
		return pathStyleAccess;
	}

	public void setPathStyleAccess(boolean pathStyleAccess) {
		this.pathStyleAccess = pathStyleAccess;
	}

	public MinioOperations getOperation() {
		return operation;
	}

	public void setOperation(MinioOperations operation) {
		this.operation = operation;
	}

	public boolean isAutocloseBody() {
		return autocloseBody;
	}

	public void setAutocloseBody(boolean autocloseBody) {
		this.autocloseBody = autocloseBody;
	}
}
