package ua.edu.ucu.apps.task1.myuser;

import java.time.LocalDateTime;

import ua.edu.ucu.apps.task1.twitter.XUser;

public class XUserAdapter implements User {

    public XUser xuser;

    public XUserAdapter(XUser xuser) {
        this.xuser = xuser;
    }

    @Override
    public String getCountry() {
        return this.xuser.getCountry();
    }

    @Override
    public String getEmail() {
        return this.xuser.getUserMail();
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        return this.xuser.getLastActiveTime();
    }
}
