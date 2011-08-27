package org.springframework.social.plurk.api.impl;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.plurk.api.PlurkProfile;
import org.springframework.social.plurk.api.PlurkUser;

public class PlurkModule extends SimpleModule
{
	public PlurkModule() {
		super("PlurkModule", new Version(1, 0, 0, null));
	}
	
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(PlurkProfile.class, PlurkProfileMixin.class);
		context.setMixInAnnotations(PlurkUser.class, PlurkUserMixin.class);
	}
}