package org.springframework.social.plurk.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.plurk.api.PlurkUser;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class PlurkProfileMixin
{
	@JsonCreator
	PlurkProfileMixin(
			@JsonProperty("user_info") PlurkUser plurkUser) {}
	
	@JsonProperty("user_info")
	private PlurkUser plurkUser;
}