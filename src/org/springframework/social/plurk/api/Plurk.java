package org.springframework.social.plurk.api;

import org.springframework.social.ApiBinding;

public interface Plurk extends ApiBinding
{
	UserOperations userOperations();
}