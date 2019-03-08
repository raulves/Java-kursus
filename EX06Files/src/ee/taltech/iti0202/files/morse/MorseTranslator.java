package ee.taltech.iti0202.files.morse;
import ee.taltech.iti0202.files.input.InputFilesReader;
import ee.taltech.iti0202.files.input.InputFilesScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {

    public Map<String, String> addMorseCodes(List<String> lines) {
        Map<String, String> morseCodes = new HashMap<>();
        for (String s : lines) {
            String[] splitS = s.split(" ");
            morseCodes.put(splitS[0].toLowerCase(), splitS[1]);
        }

        return morseCodes;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> linesInMorse = new ArrayList<>();
        for (String line : lines) {
            linesInMorse.add(translateLineToMorse(line));
        }
        return linesInMorse;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        return null;
    }

    private String translateLineToMorse(String line) {
        String translationToMorse = "";

        String[] splitLine = line.split(" ");
        List<String> lines = new InputFilesScanner().readTextFromFile("EX06Files/src/ee/taltech/iti0202/files/input/morse.txt");
        Map<String, String> morseCodes = addMorseCodes(lines);
        for (String s : splitLine) {
            String oneWordToMorse = "";
            String[] wordToLetters = s.split("");
            for (String letter : wordToLetters) {
                if (morseCodes.containsKey(letter.toLowerCase())) {
                    oneWordToMorse += " ";
                    oneWordToMorse += morseCodes.get(letter.toLowerCase());
                }



            }
            translationToMorse += "\t";
            translationToMorse += oneWordToMorse.substring(1);
        }
        return translationToMorse.substring(1);
    }

    private String translateLineFromMorse(String line) {
        return null;
    }
}