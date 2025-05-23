package com.nomnomdeli.toppings;

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
        return 0.0; // Regular toppings are free
    }
}
