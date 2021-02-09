package com.lak.messanger.resorces;

import com.lak.messanger.model.Profile;
import com.lak.messanger.services.ProfileServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResources {

  ProfileServices ps = new ProfileServices();

    @GET
    public List<Profile> getProfiles(){

        return ps.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getMessages(@PathParam("profileName") String profileName){

        return ps.getProfile(profileName);
    }

    @POST
    public Profile getMessage(Profile profile){

        return ps.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setFirstName(profileName);
        return ps.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public Profile deleteMessages(@PathParam("profileName") String profileName){
        return ps.removeProfile(profileName);
    }

}
