package com.nomnomdeli;

import com.nomnomdeli.menu.MenuService;

// Entry point for the NomNom Deli application.
// This class initializes the menu service and starts the application.

public class NomNomDeliApp {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.start();
    }
}