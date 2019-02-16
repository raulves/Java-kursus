package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SocialNetwork {

    private Set<Group> allGroups = new LinkedHashSet<>();
    private Set<Message> userMessages = new HashSet<>();

    public void registerGroup(Group group) {
        allGroups.add(group);
    }

    public Set<Group> getGroups() {
        return allGroups;
    }

    public Feed getFeedForUser(User user) {
        Feed feed = new Feed(user, userMessages);

        return feed;
    }

    @Override
    public String toString() {
        return allGroups.toString();
    }
}
