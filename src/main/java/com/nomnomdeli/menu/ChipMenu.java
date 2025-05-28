package com.nomnomdeli.menu;

import com.nomnomdeli.model.Chip;

import java.util.Scanner;

public class ChipMenu {
    private Scanner scanner;

    public ChipMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public Chip buildChip() {

        // 1. Show chip options and get user input
        System.out.println("\nChoose your chip type:");
        String[] chipTypes = {"Sweet Potato Chips", "Kettle Cooked Chips", "Baked Chips", "Pita Chips", "Veggie Chips"};

        for (int i = 0; i < chipTypes.length; i++) {
            System.out.println((i + 1) + ") " + chipTypes[i]);
        }
        System.out.print("Please select an option (1-" + chipTypes.length + "): ");

        String input = scanner.nextLine();
        int chipIndex;

        try {
            chipIndex = Integer.parseInt(input) - 1;
            if (chipIndex < 0 || chipIndex >= chipTypes.length) {
                System.out.println("Invalid option. Please try again.");
                return buildChip(); // Restart the process if input is invalid
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return buildChip(); // Restart the process if input is not a number
        }

        String selectedChipType = chipTypes[chipIndex];
        // Return a Chip object based on user input
        Chip chip = new Chip(selectedChipType);
        System.out.println("You selected: " + chip.getType() + " chips.");
        return chip;
    }
}
