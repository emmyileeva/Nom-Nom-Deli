package com.nomnomdeli.menu;

import com.nomnomdeli.model.Order;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This class provides a menu for viewing the current order summary.

public class ViewOrderMenu {
    private Scanner scanner;

    public ViewOrderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void viewCurrentOrder(Order order) {
        System.out.println();
        System.out.println(ColorTextHelper.colorize("╭────────────────────────────────────────────╮", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("│  📝  Y O U R  O R D E R  S U M M A R Y  🥗 │", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("╰────────────────────────────────────────────╯", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("🌱 Here’s what you’ve built so far! 🌱", ColorTextHelper.MINT));
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println(ColorTextHelper.colorize(order.toString(), ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println(ColorTextHelper.colorize("Press Enter to return to the Order Menu.", ColorTextHelper.LIME));
        scanner.nextLine(); // Wait for user input to return to the main menu
    }
}
