package ua.edu.ucu.apps.task1.myuser;

import java.time.LocalDateTime;

public interface User {
    public String getEmail();
    public LocalDateTime getLastActiveTime();
    public String getCountry();
}
