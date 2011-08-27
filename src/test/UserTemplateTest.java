package test;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

import org.junit.Test;
import org.springframework.social.plurk.api.PlurkProfile;

public class UserTemplateTest extends AbstractPlurkApiTest
{
	@Test
	public void getUserProfile() throws Exception {
		mockServer.expect(requestTo("http://www.plurk.com/APP/Profile/getOwnProfile"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("plurk-profile"), responseHeaders));

		PlurkProfile profile = plurk.userOperations().getUserProfile();
		assertEquals(161064614, profile.getPlurkUser().getId());
	}
}