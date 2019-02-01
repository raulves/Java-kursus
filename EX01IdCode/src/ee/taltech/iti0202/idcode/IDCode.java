package ee.taltech.iti0202.idcode;

public class IDCode {
    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        return false;
    }

    private static boolean isGenderNumberCorrect(String idCode) {
        int gender = Integer.parseInt(idCode.substring(0, 1));

        for (int i = 1; i < 7; i++) {
            if (i == gender) {
                return true;
            }
        }


        return false;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        int year = Integer.parseInt(idCode.substring(1, 3));
        if  (year < 100) {
            return true;
        }
        return false;
    }

    private static boolean isMonthNumberCorrect(String idCode) {
        int month = Integer.parseInt(idCode.substring(3, 5));
        for (int i = 1; i < 13; i++) {
            if (month == i) {
                return true;
            }
        }
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

    public static void main(String[] args) {

        System.out.println(isYearNumberCorrect("39007190299"));
    }
}


