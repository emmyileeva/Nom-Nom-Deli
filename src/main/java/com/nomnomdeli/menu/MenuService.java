package com.nomnomdeli.menu;


import com.nomnomdeli.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuService {
    private Scanner scanner;

    public MenuService() {
        this.scanner = new Scanner(System.in);
    }

    // This method starts the menu service
    public void start() {
        HomeMenu homeMenu = new HomeMenu(scanner);
        boolean continueRunning = homeMenu.showHomeMenu();

        while (continueRunning) {
            // Generate a unique order ID based on the current date and time
            String orderId = "ORDER-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

            // Create a new order with the generated order ID and launch the order menu
            Order currentOrder = new Order(orderId);
            OrderMenu orderMenu = new OrderMenu(scanner, currentOrder);
            boolean orderDone = orderMenu.showOrderMenu();

            // After checkout or cancel, show home menu again
            continueRunning = homeMenu.showHomeMenu();
        }
        scanner.close();
    }
}
