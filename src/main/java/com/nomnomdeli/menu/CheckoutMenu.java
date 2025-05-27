package com.nomnomdeli.menu;

import com.nomnomdeli.model.Order;

import java.util.Scanner;

public class CheckoutMenu {
    private Scanner scanner;

    public CheckoutMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean showCheckoutMenu(Order order) {
        // 1. Show order summary
        // 2. Confirm or cancel order
        // 3. Return true if confirmed, false if canceled
        System.out.println("\n Order Summary:");
        System.out.println("--------------------------");
        System.out.println(order);
        System.out.println("--------------------------");

        System.out.println("Confirm order and save the receipt? (yes/no)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("yes") || input.equals("y")) {
            return true; // user confirmed the order
        } else {
            System.out.println("Order canceled. Returning to the main menu.");
            return false; // user canceled the order
        }
    }
}
