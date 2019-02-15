package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.LinkedHashSet;
import java.util.Set;

public class SocialNetwork {

    private Set<Group> allGroups = new LinkedHashSet<>();

    public void registerGroup(Group group) {
        allGroups.add(group);
    }

    public Set<Group> getGroups() {
        return allGroups;
    }

    public Feed getFeedForUser(User user) {
        return new Feed(null, null);
    }

    @Override
    public String toString() {
        return allGroups.toString();
    }
}
