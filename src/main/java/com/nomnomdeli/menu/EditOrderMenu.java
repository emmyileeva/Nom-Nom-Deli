package com.nomnomdeli.menu;

import com.nomnomdeli.model.Order;
import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This class allows the user to edit their sandwich order.

public class EditOrderMenu {
    private Scanner scanner;

    public EditOrderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    // This method displays the edit order menu and allows the user to edit or remove sandwiches from their order.
    public void showEditOrderMenu(Order order) {
        if (order.isEmpty()) {
            System.out.println(ColorTextHelper.colorize("🚫 Your order is empty. Please add items before editing.", ColorTextHelper.PINK));
            return;
        }

        boolean inEditOrder = true;
        while (inEditOrder) {
            System.out.println();
            System.out.println(ColorTextHelper.colorize("╭────────────────────────────────────────────╮", ColorTextHelper.AQUA));
            System.out.println(ColorTextHelper.colorize("│    🥪  E D I T   Y O U R   O R D E R  🥑   │", ColorTextHelper.AQUA));
            System.out.println(ColorTextHelper.colorize("╰────────────────────────────────────────────╯", ColorTextHelper.AQUA));
            System.out.println(ColorTextHelper.colorize("🌱 Update your sandwich lineup! 🌱", ColorTextHelper.MINT));
            System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));

            order.listSandwiches(); // Display current sandwiches in the order with their indices
            System.out.println(ColorTextHelper.colorize("0) Back to Order Menu", ColorTextHelper.LIME));
            System.out.print(ColorTextHelper.colorize("Select a sandwich number to edit/remove: ", ColorTextHelper.LIME));

            int choice = getIntInput();

            if (choice == 0) {
                inEditOrder = false;
                continue;
            }

            int index = choice - 1; // Convert to zero-based index
            if (index >= 0 && index < order.getSandwiches().size()) {
                System.out.println(ColorTextHelper.colorize("\n1) 🗑️ Remove this sandwich", ColorTextHelper.LIME));
                System.out.println(ColorTextHelper.colorize("2) 🔄 Replace this sandwich", ColorTextHelper.LIME));
                System.out.print(ColorTextHelper.colorize("Choose an option (1 or 2): ", ColorTextHelper.LIME));
                int option = getIntInput();

                if (option == 1) {
                    order.removeSandwich(index);
                    System.out.println(ColorTextHelper.colorize("🗑️ Sandwich removed from your order!", ColorTextHelper.MINT));
                } else if (option == 2) {
                    System.out.println(ColorTextHelper.colorize("\n🥪 Build a new sandwich to replace the old one:", ColorTextHelper.LIME));
                    SandwichMenu sandwichMenu = new SandwichMenu(scanner);
                    Sandwich newSandwich = sandwichMenu.buildSandwich();
                    order.replaceSandwich(index, newSandwich);
                    System.out.println(ColorTextHelper.colorize("✅ Sandwich replaced successfully!", ColorTextHelper.MINT));
                } else {
                    System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please select 1 or 2.", ColorTextHelper.PINK));
                }
            } else {
                System.out.println(ColorTextHelper.colorize("🚫 Invalid choice. Please select a valid sandwich number.", ColorTextHelper.PINK));
            }
        }
    }

    // Helper method to get a valid integer input from the user
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print(ColorTextHelper.colorize("🚫 Invalid input. Please enter a number: ", ColorTextHelper.PINK));
            scanner.next(); // Clear the invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return input;
    }
}
