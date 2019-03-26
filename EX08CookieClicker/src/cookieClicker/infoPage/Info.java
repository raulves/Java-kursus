package cookieClicker.infoPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Info {
    @FXML
    private Button close;

    @FXML
    private Label info;

    @FXML
    protected void closeStage(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
