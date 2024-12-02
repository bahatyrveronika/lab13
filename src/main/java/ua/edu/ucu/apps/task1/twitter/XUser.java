package ua.edu.ucu.apps.task1.twitter;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class XUser {
    private String userMail;
    private String country;
    private LocalDateTime lastActiveTime;
}
