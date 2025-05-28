package com.nomnomdeli.menu;

import com.nomnomdeli.model.Sandwich;
import com.nomnomdeli.signatures.*;

import java.util.Scanner;

public class SignatureSandwichMenu {
    private Scanner scanner;

    public SignatureSandwichMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich chooseSignatureSandwich() {
        System.out.println("\nChoose a signature sandwich:");
        System.out.println("1) Green Goddess Wrap");
        System.out.println("2) Mediterranean Delight");
        System.out.println("3) Protein Powerhouse");
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
