package com.nomnomdeli.menu;

import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.signatures.*;

import java.util.Scanner;

// This class provides a menu for selecting signature sandwiches.

public class SignatureSandwichMenu {
    private Scanner scanner;

    public SignatureSandwichMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich chooseSignatureSandwich() {
        System.out.println("\nChoose a signature sandwich:");
        System.out.println("1) Green Goddess Wrap");
        System.out.println("   - Hummus, Feta, Cucumber, Avocado, Spinach, Sprouts, Pesto (Lettuce Wrap)");
        System.out.println("2) Mediterranean Delight");
        System.out.println("   - Falafel, Goat Cheese, Cucumber, Tomato, Onion, Greek Yogurt Sauce (Toasted Wheat)");
        System.out.println("3) Protein Powerhouse");
        System.out.println("   - Grilled Chicken, Turkey, Swiss, Lettuce, Bell Peppers, Mustard (Toasted Sourdough)");
        System.out.println();
        System.out.print("Please select an option (1-3) or type 0 to cancel: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                return new GreenGoddessWrap();
            case "2":
                return new MediterraneanDelight();
            case "3":
                return new ProteinPowerhouse();
            case "0":
                System.out.println("Cancelled signature sandwich selection.");
                return null; // Return null to indicate cancellation
            default:
                System.out.println("Invalid option. Please try again.");
                return chooseSignatureSandwich(); // Restart the process if input is invalid
        }
    }
}
