package ee.taltech.iti0202.socialnetwork.group;

import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    private String nameOfGroup;
    private User owner;
    private Set<User> usersInGroup = new HashSet<>();
    private List<Message> messagesPublished = new ArrayList<>();

    public Group(String name, User owner) {
        this.nameOfGroup = name;
        this.owner = owner;
        usersInGroup.add(owner);
    }

    public String getName() {
        return nameOfGroup;
    }

    public void setName(String name) {
        nameOfGroup = name;

    }

    public User getOwner() {
        return owner;
    }

    public void addUser(User user) {
        usersInGroup.add(user);
    }

    public Set<User> getParticipants() {
        return usersInGroup;
    }

    public void publishMessage(Message message) {
        if (usersInGroup.contains(message.getAuthor())) {
            messagesPublished.add(message);
        }
    }

    public List<Message> getMessages() {
        return messagesPublished;
    }

    @Override
    public String toString() {
        return nameOfGroup;
    }
}
