package org.springframework.social.plurk.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.social.plurk.api.PlurkUser;

public class UserInfoDeserializer extends JsonDeserializer<PlurkUser>
{
	@Override
	public PlurkUser deserialize(JsonParser jp, DeserializationContext arg1) throws IOException, JsonProcessingException
	{
		return new PlurkUser();
	}	
}