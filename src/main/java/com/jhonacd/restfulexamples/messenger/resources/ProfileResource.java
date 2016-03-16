package com.jhonacd.restfulexamples.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jhonacd.restfulexamples.messenger.model.Profile;
import com.jhonacd.restfulexamples.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}

	@POST
	public Profile addProfile(Profile pProfile) {
		return profileService.addProfile(pProfile);
	}

	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String pProfileName, Profile pProfile) {
		pProfile.setProfileName(pProfileName);
		return profileService.updateProfile(pProfile);
	}

	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String pProfileName) {
		return profileService.removeProfile(pProfileName);
	}

	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String pProfileName) {
		return profileService.getProfile(pProfileName);
	}
}