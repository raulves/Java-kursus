package ee.taltech.iti0202.logger;
import ee.taltech.iti0202.logger.filter.LogFilter;
import ee.taltech.iti0202.logger.formatter.LogFormatter;
import ee.taltech.iti0202.logger.level.Level;

import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger extends Logger {

    private String logFilePath;

    public FileLogger(String tag, String logFilePath) {
    	super(tag);
        this.logFilePath = logFilePath;
    }

    public FileLogger(String tag, String logFilePath, Level level) {
        super(tag, level);
        this.logFilePath = logFilePath;
   }

    public FileLogger(String tag, String logFilePath, Level level, LogFormatter formatter) {
        super(tag, level, formatter);
        this.logFilePath = logFilePath;
    }

    public FileLogger(String tag, String logFilePath, LogFilter filter, LogFormatter formatter) {
        super(tag, filter, formatter);
        this.logFilePath = logFilePath;
    }

    @Override
    protected void writeLog(String message) {
        try (PrintWriter printWriter = new PrintWriter(logFilePath)) {
            printWriter.println(message);


        } catch (IOException e) {


        }
        // append to log file if exists
        // if doesn't exist create file
    }
}
