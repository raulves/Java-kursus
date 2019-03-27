package cookieClicker.gameLogic;

import cookieClicker.Player;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player gamePlayer = new Player();



    @FXML
    private ImageView cookie;


    @FXML
    private Button closeButton;

    @FXML
    private Pane bp;

    @FXML
    private Label cursors;

    @FXML
    private Label cursorPrice;

    @FXML
    private Label clickers;

    @FXML
    private Label clickerPrice;

    @FXML
    private Button buyCursor;

    @FXML
    private Button buyClicker;

    @FXML
    private Label clickedCookiesCount;

    @FXML
    private Pane secondPane;

    @FXML
    private Button buyPowerClicker;

    @FXML
    private Label powerClickers;

    @FXML
    private Label powerClickerPrice;

    private double speed = 5;
    private List<Timeline> timelines = new ArrayList<>();

    // closeButton on pandud SceneBuilderis Scene peale, mis on gameControlleris ära ühendatud
    // closeSTage meetodis viitan closeButtonile.Kuna ta on Scene peale pandud, siis saame küsida Scene ja Windowi. Ning sulgeda.
    @FXML
    protected void closeStage(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    // Klikkides muudab küpsise suurust.
    private void resizeCookie(ImageView cookie) {
        ScaleTransition st = new ScaleTransition(Duration.millis(35), cookie);
        st.setFromY(1);
        st.setFromX(1);
        st.setToY(1.2);
        st.setToX(1.2);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }

    private void showPointsOnScene(Double x, Double y) {

        Label label = new Label();
        label.setText("+ " + gamePlayer.getCursors());
        label.setTextFill(Color.WHITE);
        bp.getChildren().add(label);
        PathTransition pathTransition = new PathTransition(Duration.millis(2000),
                new Line(x, y, x, -50), label);

        pathTransition.setCycleCount(1);
        pathTransition.play();
        pathTransition.setOnFinished(q -> bp.getChildren().remove(label));
    }

    private void addClicks() {
        gamePlayer.setClickedCookies(gamePlayer.getClickedCookies() + gamePlayer.getCursors());
        clickedCookiesCount.setText(Integer.toString(gamePlayer.getClickedCookies()));
    }

    @FXML
    public void clickCookie(MouseEvent event) {
        resizeCookie(cookie);
        showPointsOnScene(event.getSceneX(), event.getSceneY());
        addClicks();
        visibilityToTrue();
    }

    @FXML
    public void clickBuyCursor(MouseEvent event) {

        System.out.println("BUY");
        // Vähendan klikitud cookide kogust
        gamePlayer.setClickedCookies(gamePlayer.getClickedCookies() - gamePlayer.getCursorPrice());
        clickedCookiesCount.setText(Integer.toString(gamePlayer.getClickedCookies()));
        // Muudan cursori hinna ära
        gamePlayer.setCursorPrice(gamePlayer.getCursorPrice() + 10);
        cursorPrice.setText(Integer.toString(gamePlayer.getCursorPrice()));
        // Muudan cursori koguse ära
        gamePlayer.setCursors(gamePlayer.getCursors() + 1);
        cursors.setText(Integer.toString(gamePlayer.getCursors()));


        // Kontrollin, kas button jätta aktiivseks või mitte.
        if (gamePlayer.getClickedCookies() >= gamePlayer.getCursorPrice()) {
            buyCursor.setVisible(true);
        }
        visibilityToFalse();
    }

    @FXML
    public void clickBuyClicker(MouseEvent event) {

        // Vähendan klikitud cookide kogust
        gamePlayer.setClickedCookies(gamePlayer.getClickedCookies() - gamePlayer.getClickerPrice());
        clickedCookiesCount.setText(Integer.toString(gamePlayer.getClickedCookies()));
        // Muudan clickeri hinna ära
        gamePlayer.setClickerPrice(gamePlayer.getClickerPrice() + 50);
        clickerPrice.setText(Integer.toString(gamePlayer.getClickerPrice()));
        // Muudan clickeri koguse ära
        gamePlayer.setClickers(gamePlayer.getClickers() + 1);
        clickers.setText(Integer.toString(gamePlayer.getClickers()));

        // Kontrollin, kas button jätta aktiivseks või mitte.
        if (gamePlayer.getClickedCookies() >= gamePlayer.getClickerPrice()) {
            buyClicker.setVisible(true);
        }
        visibilityToFalse();

        if (gamePlayer.getClickers() == 1) {
            addTimeline();
            timelines.get(0).play();
        }

        if (speed > 1.01 && gamePlayer.getClickers() > 1) {
            timelines.get(0).stop();
            timelines.clear();
            speed = speed - 0.1;
            addTimeline();
            timelines.get(0).play();
        } else {
            buyClicker.setVisible(false);
        }
    }

    private void addTimeline() {
        Timeline t = new Timeline(new KeyFrame(Duration.seconds(speed), e -> {
            addClicks();
            visibilityToTrue();
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        timelines.add(t);
    }

    @FXML
    public void clickBuyPowerClicker(MouseEvent event) {
        // Vähendan klikitud cookide kogust
        gamePlayer.setClickedCookies(gamePlayer.getClickedCookies() - gamePlayer.getPowerClickerPrice());
        clickedCookiesCount.setText(Integer.toString(gamePlayer.getClickedCookies()));
        // Muudan PowerClickeri hinna ära
        gamePlayer.setPowerClickerPrice(gamePlayer.getPowerClickerPrice() + 200);
        powerClickerPrice.setText(Integer.toString(gamePlayer.getPowerClickerPrice()));
        // Muudan PowerClickeri koguse ära
        gamePlayer.setPowerClickers(gamePlayer.getPowerClickers() + 1);
        powerClickers.setText(Integer.toString(gamePlayer.getPowerClickers()));

        // Kontrollin, kas button jätta aktiivseks või mitte.
        if (gamePlayer.getClickedCookies() >= gamePlayer.getPowerClickerPrice()) {
            buyPowerClicker.setVisible(true);
        }
        visibilityToFalse();

        Timeline time = new Timeline();
        time = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            gamePlayer.setClickedCookies(gamePlayer.getClickedCookies() + gamePlayer.getPowerClickers() * 10);
            clickedCookiesCount.setText(Integer.toString(gamePlayer.getClickedCookies()));
            visibilityToTrue();

        }));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
    }

    private void visibilityToTrue() {
        if (gamePlayer.getClickedCookies() >= gamePlayer.getPowerClickerPrice()) {
            buyPowerClicker.setVisible(true);
        }
        if (gamePlayer.getClickedCookies() >= gamePlayer.getClickerPrice()) {
            buyClicker.setVisible(true);
        }
        if (gamePlayer.getClickedCookies() >= gamePlayer.getCursorPrice()) {
            buyCursor.setVisible(true);
        }
    }

    private void visibilityToFalse() {
        if (gamePlayer.getClickedCookies() < gamePlayer.getPowerClickerPrice()) {
            buyPowerClicker.setVisible(false);
        }
        if (gamePlayer.getClickedCookies() < gamePlayer.getCursorPrice()) {
            buyCursor.setVisible(false);
        }
        if (gamePlayer.getClickedCookies() < gamePlayer.getClickerPrice()) {
            buyClicker.setVisible(false);
        }


    }

    @FXML
    public void openInfoWindow() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/cookieClicker/infoPage/InfoFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("MainCSS.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

}
