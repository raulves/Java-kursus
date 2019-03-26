package cookieClicker;

public class Player {



    private int cursors;
    private int clickers;
    private int cursorPrice;
    private int clickerPrice;
    private int clickedCookies;
    private int powerClickers;
    private int powerClickerPrice;

    public Player() {
        this.cursors = 1;
        this.clickers = 0;
        this.cursorPrice = 10;
        this.clickerPrice = 50;
        this.clickedCookies = 0;
        this.powerClickers = 0;
        this.powerClickerPrice = 200;

    }

    public int getCursors() {
        return cursors;
    }

    public void setCursors(int cursors) {
        this.cursors = cursors;
    }

    public int getClickers() {
        return clickers;
    }

    public void setClickers(int clickers) {
        this.clickers = clickers;
    }

    public int getCursorPrice() {
        return cursorPrice;
    }

    public void setCursorPrice(int cursorPrice) {
        this.cursorPrice = cursorPrice;
    }

    public int getClickerPrice() {
        return clickerPrice;
    }

    public void setClickerPrice(int clickerPrice) {
        this.clickerPrice = clickerPrice;
    }

    public int getClickedCookies() {
        return clickedCookies;
    }

    public void setClickedCookies(int clickedCookies) {
        this.clickedCookies = clickedCookies;
    }

    public int getPowerClickers() {
        return powerClickers;
    }

    public void setPowerClickers(int powerClickers) {
        this.powerClickers = powerClickers;
    }

    public int getPowerClickerPrice() {
        return powerClickerPrice;
    }

    public void setPowerClickerPrice(int powerClickerPrice) {
        this.powerClickerPrice = powerClickerPrice;
    }
}
