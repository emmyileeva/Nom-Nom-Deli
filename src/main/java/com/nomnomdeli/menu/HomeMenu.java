package com.nomnomdeli.menu;

import java.util.Scanner;

// This class displays the main welcome screen of the app.

public class HomeMenu {
    private Scanner scanner;

    public HomeMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    // This method displays the home menu and handles user input
    public boolean showHomeMenu() {
        while (true) {
            System.out.println("\n🥪 Welcome to Nom Nom Deli! 🥪");
            System.out.println("----------------------------");
            System.out.println("1) Start a new order");
            System.out.println("0) Exit");
            System.out.print("Please select an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    return true; // Start a new order
                case "0":
                    System.out.println("Thank you for visiting Nom Nom Deli! Goodbye!");
                    return false; // Exit the application
                default:
                    System.out.println("Invalid option. Please try again.");
                    return true; // Show the menu again
            }
        }
    }
}
