package com.nomnomdeli.menu;

import com.nomnomdeli.model.Chip;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This class handles the chip selection menu for the app.

public class ChipMenu {
    private Scanner scanner;

    public ChipMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    // This method builds a Chip object based on user input from the menu.
    public Chip buildChip() {

        String[] chipTypes = {
                "Sweet Potato Chips", "Kettle Cooked Chips", "Baked Chips", "Pita Chips", "Veggie Chips"
        };
        String[] chipEmojis = {
                "🍠", "🥔", "🍘", "🥙", "🥦"
        };

        System.out.println();
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("     🥔  C H O O S E   A   C H I P  🥦      ", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("🌱 Pick a crunchy side! 🌱", ColorTextHelper.MINT));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println();

        while (true) {
            // 1. Show chip options and get user input
            System.out.println(ColorTextHelper.colorize("\nChoose your chip type:", ColorTextHelper.LIME));
            for (int i = 0; i < chipTypes.length; i++) {
                System.out.println(ColorTextHelper.colorize((i + 1) + ") " + chipEmojis[i] + " " + chipTypes[i], ColorTextHelper.LIME));
            }
            System.out.print(ColorTextHelper.colorize("Please select an option (1-" + chipTypes.length + "): ", ColorTextHelper.LIME));

            String input = scanner.nextLine();
            int chipIndex;

            try {
                chipIndex = Integer.parseInt(input) - 1;
                if (chipIndex < 0 || chipIndex >= chipTypes.length) {
                    System.out.println();
                    System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
                    System.out.println();
                    return buildChip(); // Restart the process if input is invalid
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println(ColorTextHelper.colorize("🚫 Invalid input. Please enter a number.", ColorTextHelper.PINK));
                System.out.println();
                return buildChip(); // Restart the process if input is not a number
            }

            String selectedChipType = chipTypes[chipIndex];
            // Return a Chip object based on user input
            Chip chip = new Chip(selectedChipType);
            System.out.println();
            System.out.println(ColorTextHelper.colorize("🥔 You selected: " + selectedChipType + "! 🥦", ColorTextHelper.MINT));
            System.out.println();
            return chip;
        }
    }
}
