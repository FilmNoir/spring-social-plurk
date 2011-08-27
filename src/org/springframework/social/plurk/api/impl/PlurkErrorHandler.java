package org.springframework.social.plurk.api.impl;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.InternalServerErrorException;
import org.springframework.social.ServerDownException;
import org.springframework.social.ServerOverloadedException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class PlurkErrorHandler extends DefaultResponseErrorHandler
{
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();		
		if (statusCode.series() == Series.SERVER_ERROR) {
			
			System.out.println( "----------------------- Server Error: " +  statusCode );
			
			handleServerErrors(statusCode);
		} else if (statusCode.series() == Series.CLIENT_ERROR) {
			
			System.out.println( "----------------------- Client Error: " +  statusCode );
			
			handleClientErrors(response);
		}

		// if not otherwise handled, do default handling and wrap with UncategorizedApiException
		try {
			super.handleError(response);
		} catch(Exception e) {
			throw new UncategorizedApiException("Error consuming Plurk REST API", e);
		}
	}
	
	private void handleClientErrors(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();
		Map<String, Object> errorMap = extractErrorDetailsFromResponse(response);
		if (errorMap == null) {
			return; // unexpected error body, can't be handled here
		}
	}
	
	private void handleServerErrors(HttpStatus statusCode) throws IOException {
		if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR) {
			throw new InternalServerErrorException("Something is broken at Plurk. Please see http://www.plurk.com to report the issue.");
		} else if (statusCode == HttpStatus.BAD_GATEWAY) {
			throw new ServerDownException("Plurk is down or is being upgraded.");
		} else if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
			throw new ServerOverloadedException("Plurk is overloaded with requests. Try again later.");
		}
	}
	
	private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response) throws IOException
	{
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		try {
			return mapper.<Map<String, Object>>readValue(response.getBody(), new TypeReference<Map<String, Object>>() {});
		} catch (JsonParseException e) {
			return null;
		}
	}
}