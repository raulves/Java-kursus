package ee.taltech.iti0202.files.output;
import ee.taltech.iti0202.files.exception.FileReaderException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OutputFilesWriter {

    public boolean writeLinesToFile(List<String> lines, String filename) {
        List<String> tesxtToWrite = new ArrayList<>(lines);

        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (String s : tesxtToWrite) {
                printWriter.println(s);
            }
            return true;


        } catch (IOException e) {
            return false;

        }
    }
}