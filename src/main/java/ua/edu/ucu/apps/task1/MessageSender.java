package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

import ua.edu.ucu.apps.task1.myuser.User;

public class MessageSender {
    public String send(String text, User user, String country) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourAgo = now.minusHours(1);

        if (user.getCountry() == country && oneHourAgo.isBefore(user.getLastActiveTime())) {
            System.out.println("Message '" + text + "' was sent successfully!");
        } else {
            System.out.println("Message can't be sent");
        }
        return "Thanks!";
    }
}
