package org.springframework.social.plurk.api.impl;

import org.springframework.social.plurk.api.PlurkProfile;
import org.springframework.social.plurk.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractPlurkOperations implements UserOperations
{
	private final RestTemplate restTemplate;

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public PlurkProfile getUserProfile()
	{
		requireAuthorization();
		return restTemplate.getForObject(buildUri("APP/Profile/getOwnProfile"), PlurkProfile.class);
	}

	@Override
	public PlurkProfile getUserProfile(String screenName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlurkProfile getUserProfile(long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}