package ua.edu.ucu.apps.task1.myuser;

import java.time.LocalDateTime;

import ua.edu.ucu.apps.task1.meta.FacebookUser;

public class FacebookUserAdapter implements User {
    public FacebookUser facebookuser;

    public FacebookUserAdapter(FacebookUser facebookUser) {
        this.facebookuser = facebookUser;
    }

    @Override
    public String getCountry() {
        return this.facebookuser.getUserCountry();
    }

    @Override
    public String getEmail() {
        return this.facebookuser.getEmail();
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        return this.facebookuser.getUserActiveTime();
    } 
}
