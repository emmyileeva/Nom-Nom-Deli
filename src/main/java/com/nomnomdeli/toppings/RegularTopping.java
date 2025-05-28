package com.nomnomdeli.toppings;

// This class represents a regular topping that is always free.

public class RegularTopping implements Topping {
    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0.0; // Regular toppings are free regardless of sandwich size
    }
}
