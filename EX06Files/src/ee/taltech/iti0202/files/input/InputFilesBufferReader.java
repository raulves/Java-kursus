package ee.taltech.iti0202.files.input;
import ee.taltech.iti0202.files.exception.FileReaderException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> textFromFileInList = new ArrayList<>();
        BufferedReader br = null;

        try  {
            br = new BufferedReader(new FileReader(new File(filename)));
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                textFromFileInList.add(line);
            }


        } catch (IOException e) {
            throw new FileReaderException("No such file");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                System.out.println("An IOException was caught!");
            }
        }

        return textFromFileInList;
    }
}