package com.nomnomdeli.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getPrice_shouldReturnTheCorrectPriceBasedOnTheSize() {
        // Arrange
        Drink smallDrink = new Drink("Small", "Light Lemonade");
        Drink mediumDrink = new Drink("Medium", "Coconut Water");
        Drink largeDrink = new Drink("Large", "Lemon Infused Water");
        Drink invalidDrink = new Drink("Extra Large", "Invalid Drink");

        // Act & Assert
        assertEquals(2.00, smallDrink.getPrice(), 0.01);
        assertEquals(2.50, mediumDrink.getPrice(), 0.01);
        assertEquals(3.00, largeDrink.getPrice(), 0.01);
        assertEquals(0.0, invalidDrink.getPrice(), 0.01); // Assuming invalid size returns 0.0
    }

    @Test
    void toString_shouldReturnFormattedDrinkDetails() {
        // Arrange
        Drink drink = new Drink("Medium", "Coconut Water");

        // Act
        String result = drink.toString();

        // Assert
        assertEquals("Medium Coconut Water - $2.50", result);
    }
}