package com.nomnomdeli.menu;

import com.nomnomdeli.model.Drink;

import java.util.Scanner;

public class DrinkMenu {
    private Scanner scanner;

    public DrinkMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Drink buildDrink() {

        // 1. choose a drink size
        System.out.println("\nChoose your drink size:");
        System.out.println("1) Small - $2.00");
        System.out.println("2) Medium - $2.50");
        System.out.println("3) Large - $3.00");
        System.out.print("Please select an option (1-3): ");

        String sizeInput = scanner.nextLine();
        String size = null;

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
                System.out.println("Invalid option. Please try again.");
                return buildDrink();
        }

        // 2. Choose a drink flavor
        System.out.println("\nChoose your drink flavor:");
        String[] flavors = {"Cola", "Lemonade", "Iced Tea", "Orange Juice"};
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ") " + flavors[i]);
        }
        System.out.print("Please select an option (1-" + flavors.length + "): ");

        String flavorInput = scanner.nextLine();
        int flavorIndex;

        try {
            flavorIndex = Integer.parseInt(flavorInput) - 1;
            if (flavorIndex < 0 || flavorIndex >= flavors.length) {
                System.out.println("Invalid option. Please try again."); // Restart the process if input is invalid
                return buildDrink();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number."); // Restart the process if input is not a number
            return buildDrink();
        }
        String flavor = flavors[flavorIndex];

        // 3. Return the drink object
        Drink drink = new Drink(size, flavor);
        System.out.println("You have selected a " + size + " " + flavor + " drink.");
        return drink;
    }
}
