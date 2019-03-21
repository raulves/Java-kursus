package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TypeGame extends Application {

    private Stage stage;
    private FrontLogin frontLogin;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        loginScene();


    }

    public void loginScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontLoginFXML.fxml"));
        Parent root = (Parent) loader.load();
        frontLogin = (FrontLogin) loader.getController();
        frontLogin.getPlayScene(this);



        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("TypeGame");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("main.css").toString());


    }

    public void playScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gameFXML.fxml"));
        Parent root = (Parent) loader.load();
        GameController gameController = (GameController) loader.getController();



        gameController.getPlayerObject(frontLogin.returnPlayer());

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("TypeGame");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("main.css").toString());

        gameController.generateLabels();
        gameController.matchSymbols();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
