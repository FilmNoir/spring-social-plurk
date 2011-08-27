package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.plurk.api.Plurk;
import org.springframework.social.plurk.api.PlurkProfile;
import org.springframework.social.plurk.api.UserOperations;
import org.springframework.social.plurk.connect.PlurkAdapter;

public class PlurkAdapterTest
{
	private PlurkAdapter apiAdapter = new PlurkAdapter();

	private Plurk plurk = Mockito.mock(Plurk.class);

	@Test
	public void fetchProfile() {
		UserOperations userOperations = Mockito.mock(UserOperations.class);
		Mockito.when(plurk.userOperations()).thenReturn(userOperations);
		Mockito.when(userOperations.getUserProfile()).thenReturn(new PlurkProfile());
		UserProfile profile = apiAdapter.fetchUserProfile(plurk);
		
		assertEquals("Keith Donald", profile.getName());
		assertEquals("Keith", profile.getFirstName());
		assertEquals("Donald", profile.getLastName());
		assertEquals("kdonald", profile.getUsername());
	}
}