package game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class FrontLogin {

    private TypeGame gameScene;
    private Player player;

    @FXML
    private Button playButton;

    @FXML
    private TextField userName;

    public void login() {
        player = new Player(userName.toString());
        try {
            gameScene.playScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPlayScene(TypeGame game) {
        this.gameScene = game;
    }

    public Player returnPlayer() {
        return player;
    }
}
