package ee.taltech.iti0202.idcode;

import java.util.Arrays;

public class IDCode {

    private enum Gender {
        MALE, FEMALE
    }

    public static boolean isIDCodeCorrect(String idCode) {
        if (idCode.length() == 11) {
            if (idCode.matches("[0-9]+")) {
                if (isGenderNumberCorrect(idCode)) {
                    if (isYearNumberCorrect(idCode)) {
                        if (isMonthNumberCorrect(idCode)) {
                            if (isDayNumberCorrect(idCode)) {
                                if (isQueueNumberCorrect(idCode)) {
                                    if (isControlNumberCorrect(idCode)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
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
        if (month < 13 && month > 0) {
            return true;
        }

        return false;
    }

    private static boolean isDayNumberCorrect(String idCode) {
        int fullYear = getFullYear(idCode);
        boolean leapYear = isLeapYear(fullYear);
        int day = Integer.parseInt(idCode.substring(5, 7));
        int month = Integer.parseInt(idCode.substring(3, 5));
        int[] monthsLong = {1, 3, 5, 7, 8, 10, 12};
        int[] monthsShort = {4, 6, 9, 11};
        if (day > 31) {
            return false;
        }
        if (month == 2) {
            if (day > 29) {
                return false;
            } else if (day < 29) {
                return true;
            } else {
                if (leapYear) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        for (int nr: monthsLong) {
            if (nr == month) {
                return true;
            }
        }
        for (int nrs: monthsShort) {
            if (nrs == month) {
                if (day < 31) {
                    return true;
                } else {
                    return false;
                }
            }
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
        int[] numbers1 = {1,2,3,4,5,6,7,8,9,1};
        int[] numbers2 = {3,4,5,6,7,8,9,1,2,3};
        int count = 0;
        int y = 0;
        int mod = 0;
        int count2 = 0;
        int s = 0;
        int mod2 = 0;


        if (idCode.length() == 11) {
            if (idCode.matches("[0-9]+")) {
                for (int nr: numbers1) {
                    count += nr * Integer.parseInt(idCode.substring(y, y + 1));
                    y += 1;
                    mod = count % 11;
                 }
                if (mod == 10) {
                    for (int nrs: numbers2) {
                        count2 += nrs * Integer.parseInt(idCode.substring(s, s + 1));
                        s += 1;
                        mod2 = count2 % 11;
                    }
                    if (mod2 == 10) {
                        if (0 == Integer.parseInt(idCode.substring(10, 11))) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (mod2 == Integer.parseInt(idCode.substring(10, 11))) {
                        return true;
                    } else {
                        return false;
                    }



                } else if (mod == Integer.parseInt(idCode.substring(10, 11))) {
                    return true;
                } else {
                    return false;
                }

                }

        }


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
        int day = Integer.parseInt(idCode.substring(3, 5));
        String dayString = Integer.toString(day);
        if (dayString.length() == 1) {
            dayString = "0" + dayString;

        }
        if (isIDCodeCorrect(idCode)) {
            return "This is a " + getGender(idCode).toString().toLowerCase() + " born on " + Integer.parseInt(idCode.substring(5, 7)) + "." + dayString + "." + getFullYear(idCode);
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
        System.out.println(isIDCodeCorrect("39007190299"));
        System.out.println(getInformationFromIDCode("39007190299"));
    }
}


