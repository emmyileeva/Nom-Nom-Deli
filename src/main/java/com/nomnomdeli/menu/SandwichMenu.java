package com.nomnomdeli.menu;

import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.toppings.*;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class provides a menu for building a custom sandwich.

public class SandwichMenu {
    private Scanner scanner;

    public SandwichMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich buildSandwich() {

        System.out.println();
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("🥪  B U I L D   Y O U R   S A N D W I C H  🥑", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("🌱 Let's craft a fresh sandwich! 🌱", ColorTextHelper.MINT));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println();

        // 1. Choose a sandwich size
        System.out.println(ColorTextHelper.colorize("\nChoose your sandwich size:", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("1) 🥖 4\" - $5.50", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("2) 🥖 8\" - $7.00", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("3) 🥖 12\" - $8.50", ColorTextHelper.LIME));
        System.out.println();
        System.out.print(ColorTextHelper.colorize("Please select an option (1-3): ", ColorTextHelper.LIME));

        String sizeInput = scanner.nextLine();
        String size = switch (sizeInput) {
            case "1" -> "4";
            case "2" -> "8";
            case "3" -> "12";
            default -> null;
        };

        if (size == null) {
            System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
            return buildSandwich();
        }

        // 2. Choose bread type
        System.out.println();
        System.out.println(ColorTextHelper.colorize("\nChoose your bread:", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("1) 🍞 White", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("2) 🌾 Wheat", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("3) 🥖 Sourdough", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("4) 🌾 Gluten-Free", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("5) 🥬 Lettuce Wrap", ColorTextHelper.LIME));
        System.out.println();
        System.out.print(ColorTextHelper.colorize("Please select an option (1-5): ", ColorTextHelper.LIME));

        String breadInput = scanner.nextLine();
        String bread = switch (breadInput) {
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Sourdough";
            case "4" -> "Gluten-Free";
            case "5" -> "Lettuce Wrap";
            default -> null;
        };

        if (bread == null) {
            System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
            return buildSandwich();
        }

        // 3. Toasted?
        // This loop validates user input for 'toasted' to make sure it is either 'yes' or 'no' or 'y' or 'n'.
        boolean toasted = false;
        while (true) {
            System.out.println();
            System.out.print(ColorTextHelper.colorize("\nWould you like your bread toasted? (yes/no): ", ColorTextHelper.LIME));
            String toastedInput = scanner.nextLine().trim().toLowerCase();
            if (toastedInput.equals("yes") || toastedInput.equals("y")) {
                toasted = true;
                break;
            } else if (toastedInput.equals("no") || toastedInput.equals("n")) {
                toasted = false;
                break;
            } else {
                System.out.println(ColorTextHelper.colorize("⚠️ Please enter 'yes' or 'no' (or 'y'/'n').", ColorTextHelper.PINK));
            }
        }

        List<Topping> toppings = new ArrayList<>();
        // Toppings are grouped and added in three separate calls for protein, cheese, and veggies/sauces, each with specific behavior for extra options.
        toppings.addAll(chooseMultiple("protein", new String[]{"Turkey", "Grilled Chicken", "Hummus", "Tuna", "Tofu", "Falafel"}, new String[]{"🦃", "🍗", "🌱", "🐟", "🌱", "🥙"}, true));
        toppings.addAll(chooseMultiple("cheese", new String[]{"Cheddar", "Swiss", "Provolone", "Pepper Jack", "Goat Cheese", "Feta"}, new String[]{"🧀", "🧀", "🧀", "🧀", "🐐", "🧀"}, true));
        toppings.addAll(chooseMultiple("veggies/sauces", new String[]{
                "Lettuce", "Tomato", "Onion", "Jalapeños", "Pickles", "Bell Peppers", "Cucumber", "Avocado", "Spinach", "Sprouts", "Sun-Dried Tomatoes",
                "Mustard", "Light Mayo", "Ketchup", "Ranch", "Pesto", "Cranberry Sauce", "Greek Yogurt Sauce"
        }, new String[]{
                "🥬", "🍅", "🧅", "🌶️", "🥒", "🫑", "🥒", "🥑", "🥬", "🌱", "🍅",
                "🌱", "🥚", "🍅", "🥛", "🌿", "🍒", "🥛"
        }, false));

        Sandwich sandwich = new Sandwich(size, bread, toasted);
        toppings.forEach(sandwich::addTopping);

        System.out.println();
        System.out.println(ColorTextHelper.colorize("\n🥗 Your sandwich has been built! 🥗", ColorTextHelper.MINT));
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println(ColorTextHelper.colorize(sandwich.toString(), ColorTextHelper.FRESH));

        return sandwich;
    }

    private List<Topping> chooseMultiple(String label, String[] options, String[] emojis, boolean askExtra) {
        List<Topping> selected = new ArrayList<>();
        System.out.println(ColorTextHelper.colorize("\nChoose your " + label + " (you can enter multiple, separated by commas):", ColorTextHelper.LIME));
        for (int i = 0; i < options.length; i++) {
            System.out.println(ColorTextHelper.colorize(" - " + emojis[i] + " " + options[i], ColorTextHelper.LIME));
        }
        System.out.print("\n> ");
        // This splits the user's input into individual toppings based on commas.
        String[] inputItems = scanner.nextLine().split(",");
        for (String item : inputItems) {
            String trimmed = item.trim();
            boolean found = false;
            for (int i = 0; i < options.length; i++) {
                if (trimmed.equalsIgnoreCase(options[i])) {
                    found = true;
                    // The label string determines what type of topping to instantiate.
                    if (label.contains("protein")) {
                        boolean extra = askExtra ? askExtra(trimmed) : false;
                        selected.add(new Meat(trimmed, extra));
                    } else if (label.contains("cheese")) {
                        boolean extra = askExtra ? askExtra(trimmed) : false;
                        selected.add(new Cheese(trimmed, extra));
                    } else {
                        selected.add(new RegularTopping(trimmed));
                    }
                }
            }
            if (!found) {
                System.out.println(ColorTextHelper.colorize("⚠️ '" + trimmed + "' is not a valid option. Skipped.", ColorTextHelper.PINK));
            }
        }
        return selected;
    }

    private boolean askExtra(String itemName) {
        System.out.print(ColorTextHelper.colorize("Make " + itemName + " extra? (yes/no): ", ColorTextHelper.LIME));
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes") || input.equals("y");
    }
}
