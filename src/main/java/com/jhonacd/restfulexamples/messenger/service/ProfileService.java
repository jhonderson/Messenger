package com.jhonacd.restfulexamples.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jhonacd.restfulexamples.messenger.database.DatabaseClass;
import com.jhonacd.restfulexamples.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("jhonacd", new Profile(1, "jhonacd", "jhon", "cardenas"));
		profiles.put("angelamsy", new Profile(2, "angelamsy", "angela", "salazar"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String pProfileName) {
		return profiles.get(pProfileName);
	}

	public Profile addProfile(Profile pProfile) {
		pProfile.setId(profiles.size() + 1);
		profiles.put(pProfile.getProfileName(), pProfile);
		return pProfile;
	}

	public Profile updateProfile(Profile pProfile) {
		if (pProfile.getProfileName() == null || pProfile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(pProfile.getProfileName(), pProfile);
		return pProfile;
	}

	public Profile removeProfile(String pProfileName) {
		return profiles.remove(pProfileName);
	}
}