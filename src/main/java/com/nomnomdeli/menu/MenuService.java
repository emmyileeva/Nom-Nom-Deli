package com.nomnomdeli.menu;

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
            // here is where I will show OrderMenu and handle new order flow
            continueRunning = false; // For now, exit after one iteration
        }
        scanner.close();
    }
}
