module EX08CookieClicker {
    requires javafx.controls;
    requires javafx.fxml;
    opens cookieClicker;
    opens cookieClicker.gameLogic;
    opens cookieClicker.infoPage;
}