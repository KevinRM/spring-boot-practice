package com.codebay.goldeneye.utils;

/*
 * Class for general help functions
 */
public class HelpFunctions {
    static public Integer tryParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return null;
        }
    }

    static public Boolean checkNullOrEmptyStr(String value) {
        value = value.trim(); // Remove whitespaces before and after
        return value == null || value.isEmpty();
    }

    static public String removeUndesiredCharacters(String value) {
        // Undesired basic characters (whitespace) because they have their own API
        // to remove the rest of characters
        return value.trim().replaceAll("\\s+", "");
    }
}
