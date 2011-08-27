package org.springframework.social.plurk.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.plurk.api.Plurk;

public class PlurkConnectionFactory extends OAuth1ConnectionFactory<Plurk>
{
	public PlurkConnectionFactory(String consumerKey, String consumerSecret) {
		super("plurk", new PlurkServiceProvider(consumerKey, consumerSecret), new PlurkAdapter());
	}
}