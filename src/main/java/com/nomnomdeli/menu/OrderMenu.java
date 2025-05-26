package com.nomnomdeli.menu;

import com.nomnomdeli.model.Chip;
import com.nomnomdeli.model.Drink;
import com.nomnomdeli.model.Order;
import com.nomnomdeli.model.Sandwich;

import java.util.Scanner;

public class OrderMenu {
    private Scanner scanner;
    private Order currentOrder;

    public OrderMenu(Scanner scanner, Order currentOrder) {
        this.scanner = scanner;
        this.currentOrder = currentOrder;
    }

    // This method displays the order menu and handles user input
    public boolean showOrderMenu() {
        boolean inOrder = true;

        while (inOrder) {
            System.out.println("\n🥪 Order Menu 🥪");
            System.out.println("----------------------------");
            System.out.println("1) Add a sandwich");
            System.out.println("2) Add a drink");
            System.out.println("3) Add chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Please select an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    SandwichMenu sandwichMenu = new SandwichMenu(scanner);
                    Sandwich sandwich = sandwichMenu.buildSandwich();
                    currentOrder.addSandwich(sandwich);
                    System.out.println("Sandwich added to your order!");
                    break;
                case "2":
                    DrinkMenu drinkMenu = new DrinkMenu(scanner);
                    Drink drink = drinkMenu.buildDrink();
                    currentOrder.addDrink(drink);
                    System.out.println("Drink added to your order!");
                    break;
                case "3":
                    ChipMenu chipMenu = new ChipMenu(scanner);
                    Chip chip = chipMenu.buildChip();
                    currentOrder.addChip(chip);
                    System.out.println("Chips added to your order!");
                    break;
                case "4":
                    // Checkout logic
                    break;
                case "0":
                    System.out.println("Order cancelled. Returning to home menu.");
                    inOrder = false; // Exit the order menu
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        return false; // Return to home menu
    }
}
