package com.nomnomdeli.menu;

import com.nomnomdeli.model.Order;

import java.util.Scanner;

public class ViewOrderMenu {
    private Scanner scanner;

    public ViewOrderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void viewCurrentOrder(Order order) {
        System.out.println("Current Order Summary:");
        System.out.println("----------------------------");
        System.out.println(order);
        System.out.println("----------------------------");
        System.out.println("Press Enter to return to the main menu.");
        scanner.nextLine(); // Wait for user input to return to the main menu
    }
}
