package com.nomnomdeli.menu;


import com.nomnomdeli.model.Order;

import java.util.Scanner;

// This class controls the main app loop

public class MenuService {
    private Scanner scanner;

    public MenuService() {
        this.scanner = new Scanner(System.in);
    }

    // This method starts the menu service
    public void start() {
        HomeMenu homeMenu = new HomeMenu(scanner);
        boolean continueRunning = homeMenu.showHomeMenu();

        // Loop to keep the app running until the user decides to exit
        while (continueRunning) {
            // Create a new order for each session
            Order currentOrder = new Order();
            // Show the main menu and get the user's choice
            OrderMenu orderMenu = new OrderMenu(scanner, currentOrder);
            boolean orderDone = orderMenu.showOrderMenu();

            // After checkout or cancel, show home menu again
            continueRunning = homeMenu.showHomeMenu();
        }
        scanner.close();
    }
}
