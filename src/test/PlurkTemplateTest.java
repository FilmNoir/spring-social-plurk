package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.social.plurk.api.impl.PlurkTemplate;

public class PlurkTemplateTest
{
	@Test
	public void isAuthorizedForUser() {
		PlurkTemplate plurk = new PlurkTemplate("API_KEY", "API_SECRET", "ACCESS_TOKEN", "ACCESS_TOKEN_SECRET");
		assertTrue(plurk.isAuthorized());
	}

	@Test
	public void isAuthorizedForUser_notAuthorized() {
		PlurkTemplate plurk = new PlurkTemplate();
		assertFalse(plurk.isAuthorized());
	}
}