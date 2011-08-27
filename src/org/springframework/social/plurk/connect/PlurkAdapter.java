package org.springframework.social.plurk.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.plurk.api.Plurk;
import org.springframework.social.plurk.api.PlurkProfile;

public class PlurkAdapter implements ApiAdapter<Plurk>
{
	@Override
	public UserProfile fetchUserProfile(Plurk plurk) {
		PlurkProfile profile = plurk.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getPlurkUser().getNickame()).setUsername(profile.getPlurkUser().getDisplayName()).build();
	}

	@Override
	public void setConnectionValues(Plurk plurk, ConnectionValues values) {
		PlurkProfile profile = plurk.userOperations().getUserProfile();
		values.setProviderUserId(Long.toString(profile.getPlurkUser().getId()));
		values.setDisplayName("@" + profile.getPlurkUser().getNickame());
	}

	@Override
	public boolean test(Plurk plurk)
	{
		try {
			plurk.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	@Override
	public void updateStatus(Plurk plurk, String message) {
		// TODO Auto-generated method stub
	}
}