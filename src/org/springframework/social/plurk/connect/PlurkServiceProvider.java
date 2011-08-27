package org.springframework.social.plurk.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.social.plurk.api.Plurk;
import org.springframework.social.plurk.api.impl.PlurkTemplate;

public class PlurkServiceProvider extends AbstractOAuth1ServiceProvider<Plurk>
{
	public PlurkServiceProvider(String consumerKey, String consumerSecret)
	{
		super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
				"http://www.plurk.com/OAuth/request_token",
				"http://www.plurk.com/OAuth/authorize",
				"http://www.plurk.com/OAuth/access_token", OAuth1Version.CORE_10_REVISION_A));
	}

	@Override
	public Plurk getApi(String accessToken, String secret) {
		return new PlurkTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}
}