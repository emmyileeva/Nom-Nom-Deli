package com.nomnomdeli.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipTest {

    @Test
    void getType_shouldReturnTheCorrectChipType() {
        // Arrange
        Chip chip = new Chip("Pita Chips");

        // Act
        String type = chip.getType();

        // Assert
        assertEquals("Pita Chips", type);
    }

    @Test
    void getPrice_shouldReturnTheFixedChipPrice() {
        // Arrange
        Chip chip = new Chip("Sweet Potato Chips");

        // Act
        double price = chip.getPrice();

        // Assert
        assertEquals(1.50, price, 0.01); // Price should be 1.50
    }

    @Test
    void toString_shouldReturnFormattedChipDescription() {
        // Arrange
        Chip chip = new Chip("Kettle Cooked");

        // Act
        String description = chip.toString();

        // Assert
        assertEquals("Kettle Cooked Chips - $1.50", description);
    }
}