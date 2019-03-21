package game;


public class Player {

    private int points;
    private String name;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }
}
