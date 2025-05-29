package com.nomnomdeli.utils;

// This is a utility class for displaying a loading animation using dots.
// It uses Thread.sleep to simulate delays, giving the effect of a loading process.

public class LoadingHelper {
    public static void showLoading(String message, int dotCount, int delayMillis) {
        System.out.println(message);
        for (int i = 0; i < dotCount; i++) {
            try {
                Thread.sleep(delayMillis); // Pause for the specified delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
            System.out.print("."); // Print a dot
        }
        System.out.println(); // Move to the next line after the dots
    }

    // Overloaded helper method with default dot count (3) and delay (500 ms)
    public static void showLoading(String message) {
        showLoading(message, 3, 500);
    }
}

