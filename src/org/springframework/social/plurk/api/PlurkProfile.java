package org.springframework.social.plurk.api;

import java.io.Serializable;

public class PlurkProfile implements Serializable
{
	private static final long serialVersionUID = 1L;
	private PlurkUser plurkUser;
	
	public PlurkUser getPlurkUser() {
		return plurkUser;
	}

	public void setPlurkUser(PlurkUser plurkUser) {
		this.plurkUser = plurkUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}