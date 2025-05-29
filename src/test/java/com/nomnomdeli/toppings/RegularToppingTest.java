package com.nomnomdeli.toppings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularToppingTest {

    @Test
    void getName_shouldReturnTheCorrectName() {
        // Arrange
        RegularTopping regularTopping = new RegularTopping("Lettuce");

        // Act
        String name = regularTopping.getName();

        // Assert
        assertEquals("Lettuce", name);
    }

    @Test
    void getPrice_shouldAlwaysReturnZeroRegardlessOfTheSize() {
        // Arrange
        RegularTopping regularTopping = new RegularTopping("Tomato");

        // Act & Assert
        assertEquals(0.0, regularTopping.getPrice("4"));
        assertEquals(0.0, regularTopping.getPrice("8"));
        assertEquals(0.0, regularTopping.getPrice("12"));
        assertEquals(0.0, regularTopping.getPrice("InvalidSize"));


    }
}