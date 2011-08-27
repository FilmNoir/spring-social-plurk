package test;

import org.junit.Before;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.plurk.api.impl.PlurkTemplate;
import org.springframework.social.test.client.MockRestServiceServer;

public abstract class AbstractPlurkApiTest
{
	protected PlurkTemplate plurk;
	protected PlurkTemplate unauthorizedPlurk;
	protected MockRestServiceServer mockServer;
	protected HttpHeaders responseHeaders;
	
	@Before
	public void setup() {
		plurk = new PlurkTemplate("API_KEY", "API_SECRET", "ACCESS_TOKEN", "ACCESS_TOKEN_SECRET");
		mockServer = MockRestServiceServer.createServer(plurk.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		unauthorizedPlurk = new PlurkTemplate();
		 // create a mock server just to avoid hitting real twitter if something gets past the authorization check
		MockRestServiceServer.createServer(unauthorizedPlurk.getRestTemplate());
	}
	
	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}
}