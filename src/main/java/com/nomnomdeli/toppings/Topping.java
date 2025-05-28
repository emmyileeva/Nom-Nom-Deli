package com.nomnomdeli.toppings;

// This interface defines the contract for all toppings in the app.
// It requires a method to get the name of the topping and a method to get its price based on the sandwich size.

public interface Topping {
    String getName();

    double getPrice(String sandwichSize);
}
