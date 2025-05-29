package com.nomnomdeli.menu;

import com.nomnomdeli.utils.ColorTextHelper;
import com.nomnomdeli.utils.LoadingHelper;

import java.util.Scanner;

// This class displays the main welcome screen of the app.

public class HomeMenu {
    private Scanner scanner;

    public HomeMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    // This method prints the logo of the application
    private void printLogo() {
        System.out.println(ColorTextHelper.colorize("""
                ╭──────────────────────────────╮
                │ 🥪  N O M  N O M  D E L I  🥪│
                ╰──────────────────────────────╯
                """, ColorTextHelper.AQUA));
    }

    // This method displays the home menu and handles user input
    public boolean showHomeMenu() {
        while (true) {
            printLogo();
            System.out.println(ColorTextHelper.colorize("🥖 Welcome to Nom Nom Deli 🥬", ColorTextHelper.MINT));
            System.out.println(ColorTextHelper.colorize("----------------------------", ColorTextHelper.FRESH));
            System.out.println(ColorTextHelper.colorize("1) 🥪 Start a new order", ColorTextHelper.LIME));
            System.out.println(ColorTextHelper.colorize("0) ❌ Close Up Shop", ColorTextHelper.PINK));
            System.out.print("\n" + ColorTextHelper.colorize("What would you like to do? ", ColorTextHelper.LIME));

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    LoadingHelper.showLoading(
                            ColorTextHelper.colorize("Prepping your order", ColorTextHelper.AQUA), 3, 400
                    );
                    System.out.println("\n" + ColorTextHelper.colorize("Let's build your delicious sandwich! 🥑", ColorTextHelper.MINT));
                    return true; // Start a new order
                case "0":
                    LoadingHelper.showLoading(
                            ColorTextHelper.colorize("Closing up and making sure everything is fresh for tomorrow", ColorTextHelper.FRESH), 4, 300
                    );
                    System.out.println("\n" + ColorTextHelper.colorize("Thanks for stopping by Nom Nom Deli! 🌿💚", ColorTextHelper.MINT));
                    return false; // Exit the application
                default:
                    System.out.println(ColorTextHelper.colorize("\nOops! That option doesn't exist. Please try again.\n", ColorTextHelper.PINK));
                    return true; // Show the menu again
            }
        }
    }
}
