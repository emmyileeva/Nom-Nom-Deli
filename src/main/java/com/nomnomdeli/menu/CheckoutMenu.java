package com.nomnomdeli.menu;

import com.nomnomdeli.model.Order;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This menu handles the checkout process for the user.

public class CheckoutMenu {
    private Scanner scanner;

    public CheckoutMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean showCheckoutMenu(Order order) {
        // 1. Show order summary
        // 2. Confirm or cancel order
        // 3. Return true if confirmed, false if canceled
        System.out.println();
        System.out.println(ColorTextHelper.colorize("╭────────────────────────────────────────────╮", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("│  💳  C H E C K O U T   S U M M A R Y  🧾   │", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("╰────────────────────────────────────────────╯", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("🌱 Ready to enjoy your healthy meal? 🌱", ColorTextHelper.MINT));
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println(ColorTextHelper.colorize(order.toString(), ColorTextHelper.LIME)); // toString() method should be overridden in Order class to display order details
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));

        while (true) {
            System.out.print(ColorTextHelper.colorize("Confirm order and save the receipt? (yes/no): ", ColorTextHelper.LIME));
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                System.out.println(ColorTextHelper.colorize("✅ Order confirmed! Your receipt has been saved. Thank you for choosing NomNom Deli! 🥗", ColorTextHelper.MINT));
                return true; // user confirmed the order
            } else if (input.equals("no") || input.equals("n")) {
                System.out.println(ColorTextHelper.colorize("❌ Order canceled. Returning to the main menu.", ColorTextHelper.PINK));
                return false;
            } else {
                System.out.println(ColorTextHelper.colorize("🚫 Invalid input. Please enter 'yes' or 'no'.", ColorTextHelper.PINK));
            }
        }
    }
}
