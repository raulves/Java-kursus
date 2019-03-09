package ee.taltech.iti0202.files.morse;
import ee.taltech.iti0202.files.input.InputFilesReader;
import ee.taltech.iti0202.files.input.InputFilesScanner;

import java.util.*;

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
        List<String> linesFromMorse = new ArrayList<>();
        for (String line : lines) {
            linesFromMorse.add(translateLineFromMorse(line));
        }
        return linesFromMorse;
    }

    private String translateLineToMorse(String line) {
        String translationToMorse = "";

        String[] splitLine = line.split(" ");
        List<String> lines = new InputFilesScanner().readTextFromFile("EX06Files/src/ee/taltech/iti0202/files/input/morse.txt");
        Map<String, String> morseCodes = addMorseCodes(lines);
        for (String s : splitLine) {
            System.out.println(s);
            String oneWordToMorse = "";
            System.out.println(oneWordToMorse + "YES");
            String[] wordToLetters = s.split("");
            System.out.println(Arrays.toString(wordToLetters));
            for (String letter : wordToLetters) {
                System.out.println(letter);
                // oneWordToMorse += " ";
                oneWordToMorse += " " + morseCodes.get(letter.toLowerCase());
            }
            System.out.println(oneWordToMorse.substring(1));
            // translationToMorse += "\t";
            translationToMorse += "\t" + oneWordToMorse.substring(1);
            System.out.println(translationToMorse);
        }
        return translationToMorse.substring(1);
    }

    private String translateLineFromMorse(String line) {
        String translationFromMorse = "";
        List<String> lines = new InputFilesScanner().readTextFromFile("EX06Files/src/ee/taltech/iti0202/files/input/morse.txt");
        Map<String, String> morseCodes = addMorseCodes(lines);
        Map<String, String> morseCodesUpsideDown = new HashMap<>();
        for (String key : morseCodes.keySet()) {
            morseCodesUpsideDown.put(morseCodes.get(key), key);
        }
        String[] splitLine = line.split("\t");
        for (String s : splitLine) {
            String oneWordFromMorse = "";
            String[] separateMorseWord = s.split(" ");
            for (String s1 : separateMorseWord) {
                oneWordFromMorse += morseCodesUpsideDown.get(s1);
            }
            translationFromMorse += " ";
            translationFromMorse += oneWordFromMorse;

        }


        return translationFromMorse.substring(1);
    }
}