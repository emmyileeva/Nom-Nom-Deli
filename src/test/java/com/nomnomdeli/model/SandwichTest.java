package com.nomnomdeli.model;

import com.nomnomdeli.toppings.Cheese;
import com.nomnomdeli.toppings.RegularTopping;
import com.nomnomdeli.toppings.Topping;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void addTopping_shouldBeAddingToppingsToList() {
        // Arrange
        Sandwich sandwich = new Sandwich("8", "Wheat", false);
        Topping topping = new RegularTopping("Lettuce");

        // Act
        sandwich.addTopping(topping);

        // Assert
        assertTrue(sandwich.getToppings().contains(topping));
    }

    @Test
    void getToppings_shouldReturnAllOfTheAddedToppings() {
        // Arrange
        Sandwich sandwich = new Sandwich("8", "White", true);
        Topping topping1 = new RegularTopping("Tomato");
        Topping topping2 = new RegularTopping("Pickles");
        sandwich.addTopping(topping1);
        sandwich.addTopping(topping2);

        // Act
        List<Topping> toppings = sandwich.getToppings();

        // Assert
        assertEquals(2, toppings.size());
        assertTrue(toppings.contains(topping1));
        assertTrue(toppings.contains(topping2));
    }

    @Test
    void getBasePrice_shouldReturnCorrectPriceForEachSize() {
        // Arrange & Act & Assert
        assertEquals(5.50, new Sandwich("4", "White", false).getBasePrice(), 0.01);
        assertEquals(7.00, new Sandwich("8", "Wheat", true).getBasePrice(), 0.01);
        assertEquals(8.50, new Sandwich("12", "Sourdough", true).getBasePrice(), 0.01);
        assertEquals(0.00, new Sandwich("Invalid", "White", false).getBasePrice(), 0.01);
    }

    @Test
    void getToppingPrice_shouldReturnTheTotalSumOfToppingPrices() {
        // Arrange
        Sandwich sandwich = new Sandwich("8", "White", false);
        sandwich.addTopping(new Cheese("Cheddar", false)); // should be 1.5
        sandwich.addTopping(new Cheese("Swiss", true)); // should be 2.1

        // Act
        double totalToppingPrice = sandwich.getToppingPrice();

        // Assert
        assertEquals(3.6, totalToppingPrice, 0.01);
    }

    @Test
    void getTotalPrice_shouldReturnTheBasePricePlusTheToppings() {
        // Arrange
        Sandwich sandwich = new Sandwich("4", "Wheat", false); // base price is 5.50
        sandwich.addTopping(new Cheese("Swiss", true)); // should be 1.05

        // Act
        double totalPrice = sandwich.getTotalPrice();

        // Assert
        assertEquals(6.55, totalPrice, 0.01);
    }
}