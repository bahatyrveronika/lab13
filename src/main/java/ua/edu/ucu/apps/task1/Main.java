package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

import ua.edu.ucu.apps.task1.meta.FacebookUser;
import ua.edu.ucu.apps.task1.myuser.FacebookUserAdapter;
import ua.edu.ucu.apps.task1.myuser.User;
import ua.edu.ucu.apps.task1.myuser.XUserAdapter;
import ua.edu.ucu.apps.task1.twitter.XUser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        User facebookUser = new FacebookUserAdapter(
                new FacebookUser(
                    "dhgd@gmail.com",
                    "Ukraine",
                        LocalDateTime.of(2024, 12, 2, 14, 01)
                )
        );
        User xUser = new XUserAdapter(
                new XUser(
                        "hjhjd@gmail.com",
                        "UK",
                        LocalDateTime.of(2024, 12, 2, 14, 01)
                )
        );
        MessageSender ms = new MessageSender();
        ms.send("Hello", facebookUser, "Ukraine");
        ms.send("Hello", xUser, "Ukraine");

        
    }
}