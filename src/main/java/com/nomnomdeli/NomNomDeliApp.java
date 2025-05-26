package com.nomnomdeli;

import com.nomnomdeli.menu.MenuService;

public class NomNomDeliApp {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.start();
    }
}