package ee.taltech.iti0202.idcode;

public class IDCode {

    private enum Gender {
        MALE, FEMALE
    }

    private static final int ID_LENGTH = 11;
    private static final int SUBSTRING_7 = 7;

    public static boolean isIDCodeCorrect(String idCode) {
        final int ID_LENGTH = 11;
        return idCode.length() == ID_LENGTH
                && idCode.matches("[0-9]+")
                && isGenderNumberCorrect(idCode)
                && isYearNumberCorrect(idCode)
                && isMonthNumberCorrect(idCode)
                && isDayNumberCorrect(idCode)
                && isQueueNumberCorrect(idCode)
                && isControlNumberCorrect(idCode);

    }

    private static boolean isGenderNumberCorrect(String idCode) {
        int gender = Integer.parseInt(idCode.substring(0, 1));

        final int[] genderNumbers = {1, 2, 3, 4, 5, 6};

        for (int x: genderNumbers) {
            if (x == gender) {
                return true;
            }
        }


        return false;
    }

    private static boolean isYearNumberCorrect(String idCode) {
        int year = Integer.parseInt(idCode.substring(1, 3));
        final int YEARS = 99;
        return year <= YEARS;

    }

    private static boolean isMonthNumberCorrect(String idCode) {
        int month = Integer.parseInt(idCode.substring(3, 5));
        final int MONTHS = 12;
        return month <= MONTHS && month > 0;

    }

    private static boolean isDayNumberCorrect(String idCode) {
        int fullYear = getFullYear(idCode);
        boolean leapYear = isLeapYear(fullYear);
        int day = Integer.parseInt(idCode.substring(5, SUBSTRING_7));
        int month = Integer.parseInt(idCode.substring(3, 5));
        final int[] monthsLong = {1, 3, 5, 7, 8, 10, 12};
        final int[] monthsShort = {4, 6, 9, 11};
        final int DAYS_31 = 31;
        final int DAYS_29 = 29;

        if (day > DAYS_31) {
            return false;
        }
        if (month == 2) {
            if (day > DAYS_29) {
                return false;
            } else if (day < DAYS_29) {
                return true;
            } else {
                return leapYear;
            }
        }
        for (int nr: monthsLong) {
            if (nr == month) {
                return true;
            }
        }
        for (int nrs: monthsShort) {
            if (nrs == month) {
                return day < DAYS_31;
            }
        }

        return false;
        }


    private static boolean isQueueNumberCorrect(String idCode) {
        int queueNumber = Integer.parseInt(idCode.substring(SUBSTRING_7, 10));

        return queueNumber < 1000 && queueNumber > 0;
    }

    private static boolean isControlNumberCorrect(String idCode) {
        final int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        final int[] numbers2 = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};
        final int SUBSTRING = 11;
        int count = 0;
        int index1 = 0;
        int mod = 0;
        int count2 = 0;
        int index2 = 0;
        int mod2 = 0;


        if (idCode.length() == ID_LENGTH) {
            if (idCode.matches("[0-9]+")) {
                for (int nr: numbers1) {
                    count += nr * Integer.parseInt(idCode.substring(index1, index1 + 1));
                    index1 += 1;
                    mod = count % ID_LENGTH;
                 }
                if (mod == 10) {
                    for (int nrs: numbers2) {
                        count2 += nrs * Integer.parseInt(idCode.substring(index2, index2 + 1));
                        index2 += 1;
                        mod2 = count2 % ID_LENGTH;
                    }
                    if (mod2 == 10) {
                        return 0 == Integer.parseInt(idCode.substring(10, SUBSTRING));
                    }
                    return mod2 == Integer.parseInt(idCode.substring(10, SUBSTRING));
                }
                return mod == Integer.parseInt(idCode.substring(10, SUBSTRING));
                }
        }
        return false;
    }

    private static boolean isLeapYear(int fullYear) {
        final int year400 = 400;
        final int year4 = 4;
        final int year100 = 100;
        if (fullYear % year4 == 0) {
            if (fullYear % year100 == 0) {
                return fullYear % year400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static String getInformationFromIDCode(String idCode) {
        int day = Integer.parseInt(idCode.substring(3, 5));
        String dayString = Integer.toString(day);
        if (dayString.length() == 1) {
            dayString = "0" + dayString;

        }
        if (isIDCodeCorrect(idCode)) {
            return "This is a " + getGender(idCode).toString().toLowerCase() + " born on "
                    + Integer.parseInt(idCode.substring(5, SUBSTRING_7)) + "." + dayString + "." + getFullYear(idCode);
        }

        return "Given invalid ID code!";
    }

    public static Gender getGender(String idCode) {
        char gender = idCode.charAt(0);
        if (gender == '1' || gender == '3' || gender == '5') {
            return Gender.MALE;
        } else if (gender == '2' || gender == '4' || gender == '6') {
            return Gender.FEMALE;
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
            default: return 0;
        }
        return Integer.parseInt(result);
    }
}
