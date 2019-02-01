package ee.taltech.iti0202.idcode;

public class IDCode {
    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        return false;
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        char genderNumber = idCode.charAt(0);

        switch (genderNumber) {

            case '1': return true;
                break;
            case '2': return true;
                break;
            case '3': return true;
                break;
            case '4': return true;
                break;
            case '5': return true;
                break;
            case '6': return true;
                break;
            default:
                return false;
        }

    }

    private static boolean isYearNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isQueueNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isControlNumberCorrect(String idCode) {
        return false;
    }

    private static boolean isLeapYear(int fullYear) {
        return false;
    }

    public static String getInformationFromIDCode(String idCode) {
        return "";
    }

    public static Gender getGender(String idCode) {
        return null;
    }

    public static int getFullYear(String idCode) {
        return 0;
    }
}
