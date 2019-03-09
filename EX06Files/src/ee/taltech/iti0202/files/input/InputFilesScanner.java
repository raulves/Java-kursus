package ee.taltech.iti0202.files.input;
import ee.taltech.iti0202.files.exception.FileReaderException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> textFromFileInList = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                textFromFileInList.add(line);
            }
        } catch (Exception e) {
            throw new FileReaderException("No such file");
        }
        return textFromFileInList;
    }
}
