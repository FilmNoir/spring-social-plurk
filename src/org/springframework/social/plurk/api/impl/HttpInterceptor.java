package org.springframework.social.plurk.api.impl;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class HttpInterceptor implements ClientHttpRequestInterceptor
{
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException
	{	
		System.out.println("Request -------------------------------------------- ===");
		System.out.println("URI: " + request.getURI() );
		System.out.println("Method: " + request.getMethod());
		System.out.println("Headers: " + request.getHeaders()  );
		System.out.println("ContentType: " + request.getHeaders().getContentType() );
		System.out.println("Body: " + new String(body) );
		System.out.println("-------------------------------------------- ===");
		
		ClientHttpResponse response = execution.execute(request, body);
		System.out.println("Response -------------------------------------------- ===");
		System.out.println("Status Text: " + response.getStatusText() );
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Headers: " + response.getHeaders()  );
		System.out.println("Content Type: " +  request.getHeaders().getContentType() );
		
		if( response.getBody() != null )
		{
		StringWriter writer = new StringWriter();
		IOUtils.copy(response.getBody(), writer, "UTF-8");
		String theString = writer.toString();
		
		System.out.println( "Body: " + theString );
		}
		System.out.println("-------------------------------------------- ===");
		
		return response;
	}

}
