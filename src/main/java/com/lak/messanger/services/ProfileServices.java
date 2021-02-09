package com.lak.messanger.services;

import com.lak.messanger.database.DBClass;
import com.lak.messanger.model.Message;
import com.lak.messanger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileServices {

    private Map<String, Profile> profiles = DBClass.getProfiles();

    public ProfileServices() {

        profiles.put("lakshitha", new Profile(1L, "Lakshitha", "Prabath"," Wijewardane"));
        profiles.put("Thiloka", new Profile(1L, "Thiloka", "Randunu"," Pathirana"));
        profiles.put("Saman", new Profile(1L, "Saman", "Chandana"," Smaree"));
    }

    public List<Profile> getAllProfiles() {

        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profile){

        return profiles.get(profile);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() +1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
