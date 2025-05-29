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
        String size = null;

        switch (sizeInput) {
            case "1":
                size = "4";
                break;
            case "2":
                size = "8";
                break;
            case "3":
                size = "12";
                break;
            default:
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
        String bread = null;

        switch (breadInput) {
            case "1":
                bread = "White";
                break;
            case "2":
                bread = "Wheat";
                break;
            case "3":
                bread = "Sourdough";
                break;
            case "4":
                bread = "Gluten-Free";
                break;
            case "5":
                bread = "Lettuce Wrap";
                break;
            default:
                System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
                return buildSandwich();
        }
        // 3. Toasted?
        System.out.println();
        System.out.print(ColorTextHelper.colorize("\nWould you like your bread toasted? (yes/no): ", ColorTextHelper.LIME));
        String toastedInput = scanner.nextLine().trim().toLowerCase();
        System.out.println();

        boolean toasted = toastedInput.equals("yes") || toastedInput.equals("y");

        // 4. Add Protein
        List<Topping> toppings = new ArrayList<>();

        System.out.println();
        System.out.println(ColorTextHelper.colorize("\nChoose your protein:", ColorTextHelper.LIME));
        String[] proteins = {"Turkey", "Grilled Chicken", "Hummus", "Tuna", "Tofu", "Falafel"};
        String[] proteinEmojis = {"🦃", "🍗", "🌱", "🐟", "🌱", "🥙"};

        for (int i = 0; i < proteins.length; i++) {
            System.out.print(ColorTextHelper.colorize("Add " + proteinEmojis[i] + " " + proteins[i] + "? (yes/no): ", ColorTextHelper.LIME));
            String proteinInput = scanner.nextLine().trim().toLowerCase();
            if (proteinInput.equals("yes") || proteinInput.equals("y")) {
                System.out.print(ColorTextHelper.colorize("Make " + proteins[i] + " extra? (yes/no): ", ColorTextHelper.LIME));
                String extraInput = scanner.nextLine().trim().toLowerCase();
                boolean extra = extraInput.equals("yes") || extraInput.equals("y");
                toppings.add(new Meat(proteins[i], extra));
            }
        }

        // 5. Add Cheese
        System.out.println();
        System.out.println(ColorTextHelper.colorize("\nChoose your cheese:", ColorTextHelper.LIME));
        String[] cheeses = {"Cheddar", "Swiss", "Provolone", "Pepper Jack", "Goat Cheese", "Feta"};
        String[] cheeseEmojis = {"🧀", "🧀", "🧀", "🧀", "🐐", "🧀"};

        for (int i = 0; i < cheeses.length; i++) {
            System.out.print(ColorTextHelper.colorize("Add " + cheeseEmojis[i] + " " + cheeses[i] + "? (yes/no): ", ColorTextHelper.LIME));
            String cheeseInput = scanner.nextLine().trim().toLowerCase();
            if (cheeseInput.equals("yes") || cheeseInput.equals("y")) {
                System.out.print(ColorTextHelper.colorize("Make " + cheeses[i] + " extra? (yes/no): ", ColorTextHelper.LIME));
                String extraInput = scanner.nextLine().trim().toLowerCase();
                boolean extra = extraInput.equals("yes") || extraInput.equals("y");
                toppings.add(new Cheese(cheeses[i], extra));
            }
        }

        // 6. Add veggies and sauces
        System.out.println();
        System.out.println(ColorTextHelper.colorize("\nChoose your veggies and sauces:", ColorTextHelper.LIME));
        String[] veggiesAndSauces = {
                "Lettuce", "Tomato", "Onion", "Jalapeños", "Pickles", "Bell Peppers", "Cucumber", "Avocado", "Spinach", "Sprouts", "Sun-Dried Tomatoes",
                "Mustard", "Light Mayo", "Ketchup", "Ranch", "Pesto", "Cranberry Sauce", "Greek Yogurt Sauce"
        };
        String[] veggieEmojis = {
                "🥬", "🍅", "🧅", "🌶️", "🥒", "🫑", "🥒", "🥑", "🥬", "🌱", "🍅",
                "🌱", "🥚", "🍅", "🥛", "🌿", "🍒", "🥛"
        };

        for (int i = 0; i < veggiesAndSauces.length; i++) {
            System.out.print(ColorTextHelper.colorize("Add " + veggieEmojis[i] + " " + veggiesAndSauces[i] + "? (yes/no): ", ColorTextHelper.LIME));
            String itemInput = scanner.nextLine().trim().toLowerCase();
            if (itemInput.equals("yes") || itemInput.equals("y")) {
                toppings.add(new RegularTopping(veggiesAndSauces[i]));
            }
        }

        // 7. Build the sandwich
        Sandwich sandwich = new Sandwich(size, bread, toasted);
        for (Topping topping : toppings) {
            sandwich.addTopping(topping);
        }

        System.out.println();
        System.out.println(ColorTextHelper.colorize("\n🥗 Your sandwich has been built! 🥗", ColorTextHelper.MINT));
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println(ColorTextHelper.colorize(sandwich.toString(), ColorTextHelper.FRESH));

        return sandwich;

    }
}
