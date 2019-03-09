package ee.taltech.iti0202.files.morse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {

    private static Map<String, String> morseCodesMap;



    public Map<String, String> addMorseCodes(List<String> lines) {
        Map<String, String> morseCodes = new HashMap<>();
        for (String s : lines) {
            String[] splitS = s.split(" ");
            morseCodes.put(splitS[0].toLowerCase(), splitS[1]);
        }
        morseCodesMap = morseCodes;

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
        Map<String, String> morseCodes = morseCodesMap;
        for (String s : splitLine) {
            String oneWordToMorse = "";
            String[] wordToLetters = s.split("");
            for (String letter : wordToLetters) {
                // oneWordToMorse += " ";
                oneWordToMorse += " " + morseCodes.get(letter.toLowerCase());
            }
            // translationToMorse += "\t";
            translationToMorse += "\t" + oneWordToMorse.substring(1);
        }
        return translationToMorse.substring(1);
    }

    private String translateLineFromMorse(String line) {
        String translationFromMorse = "";
        Map<String, String> morseCodes = morseCodesMap;
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
