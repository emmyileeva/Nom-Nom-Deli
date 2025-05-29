package com.nomnomdeli.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addSandwich_shouldAddToTheSandwichList() {
        // Arrange
        Order order = new Order();
        Sandwich sandwich = new Sandwich("8", "Wheat", true);

        // Act
        order.addSandwich(sandwich);

        // Assert
        assertTrue(order.getSandwiches().contains(sandwich));
    }

    @Test
    void addDrink_shouldAddToTheDrinkList() {
        // Arrange
        Order order = new Order();
        Drink drink = new Drink("Medium", "Light Lemonade");

        // Act
        order.addDrink(drink);

        // Assert
        assertTrue(order.getDrinks().contains(drink));
    }

    @Test
    void addChip_shouldAddToTheChipList() {
        // Arrange
        Order order = new Order();
        Chip chip = new Chip("Sweet Potato Chips");

        // Act
        order.addChip(chip);

        // Assert
        assertTrue(order.getChips().contains(chip));
    }

    @Test
    void isEmpty_shouldReturnTrueIfNoItemsAreAdded() {
        // Arrange
        Order order = new Order();

        // Act & Assert
        assertTrue(order.isEmpty());
    }

    @Test
    void isEmpty_shouldReturnFalseIfAnyItemsAreAdded() {
        // Arrange
        Order order = new Order();
        order.addSandwich(new Sandwich("4", "White", false));

        // Act & Assert
        assertFalse(order.isEmpty());
    }

    @Test
    void getTotalPrice_shouldReturnTheCorrectSumOfAllTheItems() {
        // Arrange
        Order order = new Order();
        order.addSandwich(new Sandwich("4", "White", false)); // 5.50
        order.addDrink(new Drink("Large", "Iced Green Tea")); // 3.00
        order.addChip(new Chip("Baked Chips")); // 1.50

        // Act
        double totalPrice = order.getTotalPrice();

        // Assert
        assertEquals(10.00, totalPrice, 0.01);
    }
}