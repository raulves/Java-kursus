package ee.taltech.iti0202.logger.log;
import ee.taltech.iti0202.logger.level.Level;

public class Log {

    private String message;
    private String tag;
    private Level level;

    public Log(String message, String tag, Level level) {

        this.message = message;
        this.tag = tag;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public String getTag() {
        return tag;
    }

    public Level getLevel() {
        return level;
    }
}
