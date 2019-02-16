package ee.taltech.iti0202.socialnetwork.message;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.HashSet;
import java.util.Set;

public class Message {
    private String title;
    private String message;
    private User author;


    public Message(String title, String message, User author) {
        this.title = title;
        this.message = message;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return message;
    }
}
