package homework3.services;


import org.jetbrains.annotations.NotNull;
import homework3.services.ExceptionClasses.InputNotEnoughValuesException;
import homework3.services.ExceptionClasses.InputTooManyValuesException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputService {
    private static final String[] keys = {"lastname", "firstname", "fathersname", "birthdate", "phone", "gender"};
    private static final int[] nameLength = {3, 28};  // относится ко всем полям ФИО
    private static final int[] phoneLength = {7, 16};
    private static final int genderLength = 1;
    private static int lang;
    private static final Map<String, String> parsedInputHashMap = new HashMap<>();


    public static Map<String, String> getParsedInputHashMap() {
        return parsedInputHashMap;
    }


    public static boolean parseInput(@NotNull String input) throws IOException {
        parsedInputHashMap.clear();
        int filled_keys = 0;
        String[] valuesArray;
        valuesArray = input.trim().replaceAll("\\s+", " ").split(" ");
        if (valuesArray.length < 6) {
            throw new InputNotEnoughValuesException("Error: not enough values");
        }
        if (valuesArray.length > 6) {
            throw new InputTooManyValuesException();
        }
        for (String s : valuesArray) {
            if ((parsedInputHashMap.get(keys[5]) == null) && (checkForGenderAndSaveValueIfTrue(s))) {
                filled_keys++;
                continue;

            }

            if ((parsedInputHashMap.get(keys[3]) == null) && (checkForBirthdateAndSaveValueIfTrue(s))) {
                filled_keys++;
                continue;
            }

            if ((parsedInputHashMap.get(keys[4]) == null) && (checkForPhoneAndSaveValueIfTrue(s))) {
                filled_keys++;
                continue;
            }

            if (((parsedInputHashMap.get(keys[0]) == null || parsedInputHashMap.get(keys[1]) == null
                    || parsedInputHashMap.get(keys[2]) == null)) && (checkForNameAndSaveValueIfTrue(s))) {
                filled_keys++;
            }
        }
        return keys.length == filled_keys;
    }


    private static boolean checkForGenderAndSaveValueIfTrue(@NotNull String s) throws IOException {
        if (s.length() == genderLength && (s.matches("[f|m]"))) {
            parsedInputHashMap.put(keys[5], s);
            return true;
        } else if (s.length() == genderLength) {
            throw new IOException("must be 'f' or 'm'");
        }
        return false;
    }


    private static boolean checkForBirthdateAndSaveValueIfTrue(@NotNull String s) {
        if (s.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            parsedInputHashMap.put(keys[3], s);
            return true;
        }
        return false;
    }


    private static boolean checkForPhoneAndSaveValueIfTrue(@NotNull String s) throws IOException {
        try {
            long phone = Long.parseLong(s);
            if (phoneLength[0] <= String.valueOf(phone).length() && String.valueOf(phone).length() <= phoneLength[1]) {
                parsedInputHashMap.put(keys[4], String.valueOf(phone));
                return true;
            } else throw new IOException("Must be from 7 to 12 symbols.");
        } catch (NumberFormatException ignored) {
            return false;
        }
    }


    private static boolean checkForNameAndSaveValueIfTrue(String s) throws IOException {
        if (!(nameLength[0] <= whatLength(s) && whatLength(s) <= nameLength[1])) {
            throw new IOException("Names are not correctly entered");
        }
        int currentLang = checkLanguage(s);

        String sFiltered = stringFilterWithHyphensAndCapitalize(s);

        if (parsedInputHashMap.get(keys[0]) == null) {
            lang = currentLang;
            parsedInputHashMap.put(keys[0], sFiltered);
            return true;

        } else if (parsedInputHashMap.get(keys[1]) == null) {
            if (lang == currentLang) {
                parsedInputHashMap.put(keys[1], sFiltered);
                return true;
            } else throw new IOException("Name language differs from last name language.");

        } else if (parsedInputHashMap.get(keys[2]) == null) {
            if (lang == currentLang) {
                parsedInputHashMap.put(keys[2], sFiltered);
                return true;
            } else throw new IOException("Fathersame language differs from name language.");

        } else {
            return false;
        }
    }


    private static int whatLength(@NotNull String s) {
        return s.replaceAll("\\p{P}", "").length();
    }


    private static int checkLanguage(@NotNull String s) throws IOException {
        if (isRussian(s.replaceAll("\\p{P}", ""))) {
            return 1;
        } else if (isEnglish(s.replaceAll("\\p{P}", ""))) {
            return 0;
        } else throw new IOException("Please use eng or rus");
    }


    private static String stringFilterWithHyphensAndCapitalize(@NotNull String s) throws IOException {
        String sFilteredWithHyphens = s.replaceAll("\\p{P}&&\\w+(?:-\\w+)+", "");

        try {
            if (sFilteredWithHyphens.matches("(.+)(-)(.+)")) {
                String[] splitHyphenedName = sFilteredWithHyphens.split("-");
                return splitHyphenedName[0].substring(0, 1).toUpperCase()
                        + splitHyphenedName[0].substring(1).toLowerCase()
                        + "-"
                        + splitHyphenedName[1].substring(0, 1).toUpperCase()
                        + splitHyphenedName[1].substring(1).toLowerCase();
            } else {
                return sFilteredWithHyphens.substring(0, 1).toUpperCase()
                        + sFilteredWithHyphens.substring(1).toLowerCase();
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Name spelling error");
        }
    }


    private static boolean isRussian(@NotNull String s) {
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (Character.UnicodeBlock.of(s.toCharArray()[i]) != Character.UnicodeBlock.CYRILLIC) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEnglish(@NotNull String s) {
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (Character.UnicodeBlock.of(s.toCharArray()[i]) != Character.UnicodeBlock.BASIC_LATIN) {
                return false;
            }
        }
        return true;
    }

}
