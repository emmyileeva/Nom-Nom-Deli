package com.nomnomdeli.utils;

// This class provides utility methods for coloring text in the console.

public class ColorTextHelper {
    public static final String RESET = "\u001B[0m";
    public static final String AQUA = "\u001B[38;5;159m";
    public static final String MINT = "\u001B[38;5;151m";
    public static final String LIME = "\u001B[38;5;193m";
    public static final String FRESH = "\u001B[38;5;194m";
    public static final String PINK = "\u001B[38;5;217m";

    public static String colorize(String message, String color) {
        return color + message + RESET;
    }
}
