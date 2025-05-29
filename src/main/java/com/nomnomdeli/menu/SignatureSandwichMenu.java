package com.nomnomdeli.menu;

import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.signatures.*;
import com.nomnomdeli.utils.ColorTextHelper;

import java.util.Scanner;

// This class provides a menu for selecting signature sandwiches.

public class SignatureSandwichMenu {
    private Scanner scanner;

    public SignatureSandwichMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich chooseSignatureSandwich() {
        System.out.println();
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("🥑  S I G N A T U R E   S A N D W I C H E S  🥗", ColorTextHelper.AQUA));
        System.out.println(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("🌱 Try one of our fresh, healthy creations! 🌱", ColorTextHelper.MINT));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("────────────────────────────────────────────", ColorTextHelper.FRESH));
        System.out.println();

        System.out.println(ColorTextHelper.colorize("1) 🥬 Green Goddess Wrap", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("   - Hummus, Feta, Cucumber, Avocado, Spinach, Sprouts, Pesto (Lettuce Wrap)", ColorTextHelper.FRESH));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("2) 🥙 Mediterranean Delight", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("   - Falafel, Goat Cheese, Cucumber, Tomato, Onion, Greek Yogurt Sauce (Toasted Wheat)", ColorTextHelper.FRESH));
        System.out.println();
        System.out.println(ColorTextHelper.colorize("3) 💪 Protein Powerhouse", ColorTextHelper.LIME));
        System.out.println(ColorTextHelper.colorize("   - Grilled Chicken, Turkey, Swiss, Lettuce, Bell Peppers, Mustard (Toasted Sourdough)", ColorTextHelper.FRESH));
        System.out.println();
        System.out.print(ColorTextHelper.colorize("Please select an option (1-3) or type 0 to cancel: ", ColorTextHelper.LIME));

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.println();
                System.out.println(ColorTextHelper.colorize("🥬 Green Goddess Wrap selected! 🥑", ColorTextHelper.MINT));
                return new GreenGoddessWrap();
            case "2":
                System.out.println();
                System.out.println(ColorTextHelper.colorize("🥙 Mediterranean Delight selected! 🫒", ColorTextHelper.MINT));
                return new MediterraneanDelight();
            case "3":
                System.out.println();
                System.out.println(ColorTextHelper.colorize("🥙 Mediterranean Delight selected! 🫒", ColorTextHelper.MINT));
                return new ProteinPowerhouse();
            case "0":
                System.out.println();
                System.out.println(ColorTextHelper.colorize("❌ Cancelled signature sandwich selection.", ColorTextHelper.PINK));
                return null; // Return null to indicate cancellation
            default:
                System.out.println();
                System.out.println(ColorTextHelper.colorize("🚫 Invalid option. Please try again.", ColorTextHelper.PINK));
                return chooseSignatureSandwich(); // Restart the process if input is invalid
        }
    }
}
