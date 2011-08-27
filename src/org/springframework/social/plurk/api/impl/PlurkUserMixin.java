package org.springframework.social.plurk.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PlurkUserMixin
{
	@JsonCreator
	PlurkUserMixin(
			@JsonProperty("id") long id,
			@JsonProperty("nick_name") String nickname,
			@JsonProperty("display_name") String displayName,
			@JsonProperty("location") String location) {}
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("nick_name")
	private String nickname;
	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("has_profile_image")
	private boolean hasProfileImage;
	@JsonProperty("avatar")
	private int avatar;
	@JsonProperty("location")
	private String location;
	@JsonProperty("default_lang")
	private String defaultLang;
	//@JsonProperty("date_of_birth")
	//private Date dateOfBirth;
	@JsonProperty("full_name")
	private String fullName;
	@JsonProperty("gender")
	private int gender;
	@JsonProperty("page_title")
	private String pageTitle;
	@JsonProperty("karma")
	private double karma;
	@JsonProperty("recruited")
	private int recruited;
	@JsonProperty("relationship")
	private String relationship;
}