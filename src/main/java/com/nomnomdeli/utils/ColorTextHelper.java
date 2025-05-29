package com.nomnomdeli.utils;

// This class provides utility methods for coloring text in the console.

public class ColorTextHelper {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PINK = "\u001B[95m";
    public static final String GREEN = "\u001B[92m";
    public static final String BLUE = "\u001B[94m";
    public static final String CYAN = "\u001B[96m";
    public static final String RED = "\u001B[91m";

    public static String colorize(String message, String color) {
        return color + message + RESET;
    }
}
