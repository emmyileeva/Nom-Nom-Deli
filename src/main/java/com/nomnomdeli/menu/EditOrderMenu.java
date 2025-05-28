package com.nomnomdeli.menu;

import com.nomnomdeli.model.Order;
import com.nomnomdeli.model.Sandwich;

import java.util.Scanner;

public class EditOrderMenu {
    private Scanner scanner;

    public EditOrderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showEditOrderMenu(Order order) {
        if (order.isEmpty()) {
            System.out.println("Your order is empty. Please add items before editing.");
            return;
        }

        boolean inEditOrder = true;
        while (inEditOrder) {
            System.out.println("\n Edit your sandwich order:");
            order.listSandwiches(); // Display current sandwiches in the order with their indices
            System.out.println("0) Back to Order Menu");
            System.out.print("Select a sandwich number to edit/remove: ");

            int choice = getIntInput();

            if (choice == 0) {
                inEditOrder = false;
                continue;
            }

            int index = choice - 1; // Convert to zero-based index
            if (index >= 0 && index < order.getSandwiches().size()) {
                System.out.println("\n1) Remove this sandwich");
                System.out.println("2) Replace this sandwich");
                System.out.print("Choose an option (1 or 2): ");
                int option = getIntInput();

                if (option == 1) {
                    order.removeSandwich(index);
                } else if (option == 2) {
                    System.out.println("\nBuild a new sandwich to replace the old one:");
                    SandwichMenu sandwichMenu = new SandwichMenu(scanner);
                    Sandwich newSandwich = sandwichMenu.buildSandwich();
                    order.replaceSandwich(index, newSandwich);
                } else {
                    System.out.println("Invalid option. Please select 1 or 2.");
                }
            } else {
                System.out.println("Invalid choice. Please select a valid sandwich number.");
            }
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear the invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return input;
    }
}
