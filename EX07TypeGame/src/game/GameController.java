package game;


import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.*;

public class GameController {

    private static final String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private Player player;
    private Map<Label, Long> labelsStartTimes = new HashMap<>();

    @FXML
    private Label points;

    @FXML
    private Pane pane;

    private List<Label> labelToShow = new ArrayList<>();

    public GameController() {
    }



    public void matchSymbols() {
        pane.setOnKeyPressed(keyEvent -> {
            int check = 0;
            for (Label label1 : labelToShow) {
                if (keyEvent.getText().equals(label1.getText())) {

                    RotateTransition rt = new RotateTransition(Duration.millis(200), label1);
                    rt.setByAngle(360);
                    rt.setCycleCount(1);
                    rt.play();
                    rt.setOnFinished(event -> makeNewLabel(label1));

                    addPoints(label1);
                    check++;

                }
            }
            if (check == 0) {
                removePoints();
            }

        });
    }

    public void generateLabels() {

        for (int i = 0; i < 3; i++) {
            Label label = new Label();
            makeNewLabel(label);
            pane.getChildren().add(label);
            labelToShow.add(label);
            labelsStartTimes.put(label, System.currentTimeMillis());
        }


    }
    // Annaks sisse sama label objekti, muudan ära sümboli ja asukoha. label.setText(String s)
    private Label makeNewLabel(Label label) {

        Random randomForText = new Random();
        int startIndex = randomForText.nextInt(symbols.length());
        label.setText(symbols.substring(startIndex, startIndex + 1));

        while (true) {
            Map<String, Integer> coords = generateCoordinates();
            Label checkLabel = new Label();
            checkLabel.setLayoutX(coords.get("x"));
            checkLabel.setLayoutY(coords.get("y"));
            int fails = 0;
            for (Label label1 : labelToShow) {
                if (checkLabel.getBoundsInParent().intersects(label1.getBoundsInParent())) {
                    fails++;
                }
            }
            if (fails == 0) {
                label.setLayoutX(coords.get("x"));
                label.setLayoutY(coords.get("y"));
                labelsStartTimes.put(label, System.currentTimeMillis());
                return label;
            }
        }
    }

    private Map<String, Integer> generateCoordinates() {
        Map<String, Integer> coordinates = new HashMap<>();

        Random randomForCoordinates = new Random();
        int randomX = randomForCoordinates.nextInt(400) + 50;
        int randomY = randomForCoordinates.nextInt(300) + 50;

        coordinates.put("x", randomX);
        coordinates.put("y", randomY);

        return coordinates;
    }

    public void getPlayerObject(Player player) {
        this.player = player;
    }

    private void addPoints(Label label) {
        long time = (System.currentTimeMillis() - labelsStartTimes.get(label));
        player.setPoints((int) (player.getPoints() + 100000 / time));
        points.setText(Integer.toString(player.getPoints()));
    }

    private void removePoints() {
        player.setPoints(player.getPoints() - 50);
        points.setText(Integer.toString(player.getPoints()));
    }
}
