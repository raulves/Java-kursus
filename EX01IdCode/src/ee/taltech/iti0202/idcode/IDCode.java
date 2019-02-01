package ee.taltech.iti0202.idcode;

public class IDCode {

    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        if (idCode.length() == 11) {
            return true;
        }
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
        if (month < 13) {
            return true;
        }

        return false;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        int day = Integer.parseInt(idCode.substring(5, 7));
        if (day < 31) {
            return true;
        }
        return false;
    }

    private static boolean isQueueNumberCorrect(String idCode) {
        int queueNumber = Integer.parseInt(idCode.substring(7, 10));

        if (queueNumber < 1000 && queueNumber > 000) {
            return true;
        }
        return false;
    }

    private static boolean isControlNumberCorrect(String idCode) {

        return false;
    }

    private static boolean isLeapYear(int fullYear) {
        if (fullYear % 4 == 0) {
            if (fullYear % 100 == 0) {
                if (fullYear % 400 == 0) {
                    return true;
                } else {
                    return false;

                }

            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static String getInformationFromIDCode(String idCode) {
        if (idCode.length() == 11) {
            return "";
        }

        return "Given invalid ID code!";
    }

    public static Gender getGender(String idCode) {
        char gender = idCode.charAt(0);

        switch (gender) {
            case '1': return Gender.MALE;
            case '2': return Gender.FEMALE;
            case '3': return Gender.MALE;
            case '4': return Gender.FEMALE;
            case '5': return Gender.MALE;
            case '6': return Gender.FEMALE;
        }
        return null;
    }

    public static int getFullYear(String idCode) {
        char gender = idCode.charAt(0);
        String result = "";
        switch (gender) {
            case '1': result = "18" + idCode.substring(1, 3);
                break;
            case '2': result = "18" + idCode.substring(1, 3);
                break;
            case '3': result = "19" + idCode.substring(1, 3);
                break;
            case '4': result = "19" + idCode.substring(1, 3);
                break;
            case '5': result = "20" + idCode.substring(1, 3);
                break;
            case '6': result = "20" + idCode.substring(1, 3);
                break;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {

        System.out.println(isYearNumberCorrect("39007190299"));
        System.out.println(isQueueNumberCorrect("39007190299"));
        System.out.println(getFullYear("39007190299"));
    }
}


