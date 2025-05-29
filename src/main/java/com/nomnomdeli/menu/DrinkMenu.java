package com.nomnomdeli.menu;

import com.nomnomdeli.model.Drink;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This class handles the drink selection menu for the app.

public class DrinkMenu {
    private Scanner scanner;

    public DrinkMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    // This method builds a Drink object based on user input from the menu.
    public Drink buildDrink() {
        String size = null;
        String flavor = null;

        // Header
        System.out.println();
        System.out.println(ColorTextHelper.colorize("╭────────────────────────────────────────────╮", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("│     🥤  C H O O S E   A   D R I N K  🥒    │", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("╰────────────────────────────────────────────╯", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("🌱 Refresh with a tasty drink! 🌱", ColorTextHelper.MINT));
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));

        // 1. choose a drink size
        while (size == null) {
            System.out.println(ColorTextHelper.colorize("\nChoose your drink size:", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("1) 🥤 Small - $2.00", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("2) 🥤 Medium - $2.50", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("3) 🥤 Large - $3.00", ColorTextHelper.LIME));
            System.out.print(ColorTextHelper.colorize("Please select an option (1-3): ", ColorTextHelper.LIME));

            String sizeInput = scanner.nextLine();

            switch (sizeInput) {
                case "1":
                    size = "Small";
                    break;
                case "2":
                    size = "Medium";
                    break;
                case "3":
                    size = "Large";
                    break;
                default:
                    System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
            }
        }

        // 2. Choose a drink flavor
        String[] flavors = {
                "Cucumber Mint Water", "Lemon Infused Water", "Light Strawberry Lemonade",
                "Light Lemonade", "Iced Green Tea", "Coconut Water"
        };
        String[] flavorEmojis = {
                "🥒", "🍋", "🍓", "🍋", "🍵", "🥥"
        };

        while (flavor == null) {
            System.out.println(ColorTextHelper.colorize("\nChoose your drink flavor:", ColorTextHelper.LIME));
            for (int i = 0; i < flavors.length; i++) {
                System.out.println(ColorTextHelper.colorize((i + 1) + ") " + flavorEmojis[i] + " " + flavors[i], ColorTextHelper.LIME));
            }
            System.out.print(ColorTextHelper.colorize("Please select an option (1-" + flavors.length + "): ", ColorTextHelper.LIME));

            String flavorInput = scanner.nextLine();
            int flavorIndex;

            try {
                flavorIndex = Integer.parseInt(flavorInput) - 1;
                if (flavorIndex >= 0 && flavorIndex < flavors.length) {
                    flavor = flavors[flavorIndex];
                } else {
                    System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
                }
            } catch (Exception e) {
                System.out.println(ColorTextHelper.colorize("🚫 Invalid input. Please enter a number.", ColorTextHelper.PINK)); // Restart the process if input is not a number
            }
        }
        // 3. Return the drink object
        Drink drink = new Drink(size, flavor);
        System.out.println(ColorTextHelper.colorize("🥤 You have selected a " + size + " " + flavor, ColorTextHelper.MINT));
        return drink;
    }
}
