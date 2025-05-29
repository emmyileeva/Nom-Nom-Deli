package com.nomnomdeli.toppings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {

    @Test
    void getPrice_shouldReturnTheCorrectPriceBasedOnTheSizeAndExtraFlag() {
        // Arrange & Act & Assert
        // 4 inch
        assertEquals(0.75, new Cheese("Cheddar", false).getPrice("4"), 0.01);
        assertEquals(1.05, new Cheese("Cheddar", true).getPrice("4"), 0.01);

        // 8 inch
        assertEquals(1.50, new Cheese("Swiss", false).getPrice("8"), 0.01);
        assertEquals(2.10, new Cheese("Swiss", true).getPrice("8"), 0.01);

        // 12 inch
        assertEquals(2.25, new Cheese("Provolone", false).getPrice("12"), 0.01);
        assertEquals(3.15, new Cheese("Provolone", true).getPrice("12"), 0.01);

        // Test with an invalid size
        assertEquals(0.00, new Cheese("Invalid", false).getPrice("InvalidSize"), 0.01);
        assertEquals(0.00, new Cheese("Invalid", true).getPrice("InvalidSize"), 0.01);
    }
}