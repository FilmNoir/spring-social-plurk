package org.springframework.social.plurk.api;

public interface UserOperations
{
	PlurkProfile getUserProfile();
	PlurkProfile getUserProfile(String screenName);
	PlurkProfile getUserProfile(long userId);
}