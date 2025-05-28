package com.nomnomdeli.menu;

import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.toppings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichMenu {
    private Scanner scanner;

    public SandwichMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich buildSandwich() {

        // 1. Choose a sandwich size
        System.out.println("\nChoose your sandwich size:");
        System.out.println("1) 4\" - $5.50");
        System.out.println("2) 8\" - $7.00");
        System.out.println("3) 12\" - $8.50");
        System.out.print("Please select an option (1-3): ");

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
                System.out.println("Invalid option. Please try again.");
                return buildSandwich();
        }

        // 2. Choose bread type
        System.out.println("\nChoose your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Sourdough");
        System.out.println("4) Gluten-Free");
        System.out.println("5) Lettuce Wrap");
        System.out.print("Please select an option (1-4): ");

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
                System.out.println("Invalid option. Please try again.");
                return buildSandwich();
        }
        // 3. Toasted?
        System.out.print("\nWould you like your bread toasted? (yes/no): ");
        String toastedInput = scanner.nextLine().trim().toLowerCase();

        boolean toasted = toastedInput.equals("yes") || toastedInput.equals("y");

        // 4. Add topping (meat, cheese, or regular topping)
        List<Topping> toppings = new ArrayList<>();

        System.out.println("\nChoose your protein:");
        String[] proteins = {"Turkey", "Grilled Chicken", "Hummus", "Tuna", "Tofu", "Falafel"};

        for (String protein : proteins) {
            System.out.println("Add " + protein + "? (yes/no): ");
            String proteinInput = scanner.nextLine().trim().toLowerCase();

            if (proteinInput.equals("yes") || proteinInput.equals("y")) {
                System.out.println("Make " + protein + " extra? (yes/no): ");
                String extraInput = scanner.nextLine().trim().toLowerCase();
                boolean extra = extraInput.equals("yes") || extraInput.equals("y");

                toppings.add(new Meat(protein, extra));
            }
        }

        System.out.println("\nChoose your cheese:");
        String[] cheeses = {"Cheddar", "Swiss", "Provolone", "Pepper Jack", "Goat Cheese", "Feta"};

        for (String cheese : cheeses) {
            System.out.println("Add " + cheese + "? (yes/no): ");
            String cheeseInput = scanner.nextLine().trim().toLowerCase();

            if (cheeseInput.equals("yes") || cheeseInput.equals("y")) {
                System.out.println("Make " + cheese + " extra? (yes/no): ");
                String extraInput = scanner.nextLine().trim().toLowerCase();
                boolean extra = extraInput.equals("yes") || extraInput.equals("y");

                toppings.add(new Cheese(cheese, extra));
            }
        }

        System.out.println("\nChoose your veggies and sauces:");
        String[] veggiesAndSauces = {"Lettuce", "Tomato", "Onion", "Jalapeños", "Pickles", "Bell Peppers", "Cucumber", "Avacado", "Spinach", "Sprouts", "Sun-Dried Tomatoes", "Mustard", "Light Mayo", "Ketchup", "ranch", "Pesto", "Cranberry Sauce", "Greek Yogurt Sauce"};

        for (String item : veggiesAndSauces) {
            System.out.println("Add " + item + "? (yes/no): ");
            String itemInput = scanner.nextLine().trim().toLowerCase();

            if (itemInput.equals("yes") || itemInput.equals("y")) {
                toppings.add(new RegularTopping(item));
            }
        }

        // 5. Build the sandwich
        Sandwich sandwich = new Sandwich(size, bread, toasted);
        for (Topping topping : toppings) {
            sandwich.addTopping(topping);
        }

        System.out.println("\nYour sandwich has been built successfully!");
        System.out.println(sandwich);

        return sandwich;

    }
}
