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
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("💳  Checkout Summary  🧾", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("🌱 Ready to enjoy your healthy meal? 🌱", ColorTextHelper.MINT));
        System.out.println();
        System.out.println(ColorTextHelper.colorize(order.toString(), ColorTextHelper.LIME)); // toString() method should be overridden in Order class to display order details
        System.out.println();

        while (true) {
            System.out.print(ColorTextHelper.colorize("Order up! 🍽️ Confirm and save your receipt? (yes/no): ", ColorTextHelper.LIME));
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes") || input.equals("y")) {
                System.out.println();
                System.out.println(ColorTextHelper.colorize("✅ Order confirmed! Your receipt is now in the kitchen. Thank you for choosing NomNom Deli! 🥗", ColorTextHelper.MINT));
                System.out.println();
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                System.out.println();
                System.out.println(ColorTextHelper.colorize("❌ Order canceled. Returning to the main menu.", ColorTextHelper.PINK));
                return false;
            } else {
                System.out.println();
                System.out.println(ColorTextHelper.colorize("🚫 Oops! Please enter 'yes' or 'no'.", ColorTextHelper.PINK));
            }
        }
    }
}
