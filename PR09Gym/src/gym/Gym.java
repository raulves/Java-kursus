package gym;

import gym.clients.ClientBuilder;
import gym.trainings.Trainings;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static final double MEMBERSHIP_FEE = 50;
    private static final double DISCOUNT = 0.5;
    private List<Trainings> trainings = new ArrayList<>();
    private List<ClientBuilder> clients = new ArrayList<>();

    public void addTraining(Trainings training) {
        trainings.add(training);
    }

    public void addClients(ClientBuilder client) {
        if (client.getHasDiscount()) {
            client.setMembershipFee(MEMBERSHIP_FEE * DISCOUNT);
        } else {
            client.setMembershipFee(MEMBERSHIP_FEE);
        }
        if (!clients.contains(client)) {
            clients.add(client);
        }

    }
    public List<ClientBuilder> getClients() {
        return clients;
    }

    public List<Trainings> getTrainings() {
        return trainings;
    }
}
