package com.nomnomdeli.toppings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatTest {

    @Test
    void getPrice_shouldReturnTheCorrectedPriceForRegularAndExtraMeat() {
        // Arrange
        Meat regularMeat = new Meat("Turkey", false); // Regular meat has a standard price
        Meat extraMeat = new Meat("Turkey", true); // Extra meat has a higher price

        // Act & Assert
        assertEquals(1.00, regularMeat.getPrice("4"), 0.01);
        assertEquals(1.50, extraMeat.getPrice("4"), 0.01);

        assertEquals(2.00, regularMeat.getPrice("8"), 0.01);
        assertEquals(3.00, extraMeat.getPrice("8"), 0.01);

        assertEquals(3.00, regularMeat.getPrice("12"), 0.01);
        assertEquals(4.50, extraMeat.getPrice("12"), 0.01);

        // Test with an invalid size
        assertEquals(0.00, regularMeat.getPrice("InvalidSize"), 0.01);
    }
}