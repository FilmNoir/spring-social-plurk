package org.springframework.social.plurk.api;

import java.util.Date;

public class PlurkUser
{
	private long id;
	private String nickame;
	private String displayName;
	private boolean hasProfileImage;
	private int avatar;
	private String location;
	private String defaultLang;
	private Date dateOfBirth;
	private String fullName;
	private int gender;
	private String pageTitle;
	private double karma;
	private int recruited;
	private String relationship;
	
	public PlurkUser() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickame() {
		return nickame;
	}
	public void setNickame(String nickame) {
		this.nickame = nickame;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public boolean isHasProfileImage() {
		return hasProfileImage;
	}
	public void setHasProfileImage(boolean hasProfileImage) {
		this.hasProfileImage = hasProfileImage;
	}
	public int getAvatar() {
		return avatar;
	}
	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDefaultLang() {
		return defaultLang;
	}
	public void setDefaultLang(String defaultLang) {
		this.defaultLang = defaultLang;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public double getKarma() {
		return karma;
	}
	public void setKarma(double karma) {
		this.karma = karma;
	}
	public int getRecruited() {
		return recruited;
	}
	public void setRecruited(int recruited) {
		this.recruited = recruited;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
}