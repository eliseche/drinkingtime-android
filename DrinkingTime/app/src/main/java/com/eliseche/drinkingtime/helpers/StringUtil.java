package com.eliseche.drinkingtime.helpers;

public class StringUtil {
    /**
     * Check if a String is null or empty
     *
     * @param stringToCheck
     * @return true if null or empty
     */
    public static boolean isNullOrEmpty(String stringToCheck) {
        if (stringToCheck != null && !stringToCheck.isEmpty()) {
            return false;
        }

        return true;
    }
}
