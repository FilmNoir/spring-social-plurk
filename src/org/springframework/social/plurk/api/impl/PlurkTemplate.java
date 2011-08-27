package org.springframework.social.plurk.api.impl;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.plurk.api.Plurk;
import org.springframework.social.plurk.api.UserOperations;

public class PlurkTemplate extends AbstractOAuth1ApiBinding implements Plurk
{
	private UserOperations userOperations;
	
	public PlurkTemplate() {
		super();
		registerPlurkJsonModule();
		getRestTemplate().setErrorHandler(new PlurkErrorHandler());
		getRestTemplate().setInterceptors( new ClientHttpRequestInterceptor[] { new HttpInterceptor() } );
		initSubApis();
	}
	
	public PlurkTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		registerPlurkJsonModule();
		getRestTemplate().setErrorHandler(new PlurkErrorHandler());
		getRestTemplate().setInterceptors( new ClientHttpRequestInterceptor[] { new HttpInterceptor() } );
		initSubApis();
	}
	
	@Override
	public UserOperations userOperations() {
		return userOperations;
	}
	
	private void registerPlurkJsonModule() {
		List<HttpMessageConverter<?>> converters = getRestTemplate().getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if(converter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
				ObjectMapper objectMapper = new ObjectMapper();				
				objectMapper.registerModule(new PlurkModule());
				jsonConverter.setObjectMapper(objectMapper);
			}
		}
	}
	
	private void initSubApis() {
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}
}