package com.nomnomdeli.toppings;

// This class represents a premium topping that may be marked as extra.
// It's an abstract class that provide a shared structure for subclasses like Meat and Cheese.

public abstract class PremiumTopping implements Topping {
    // using protected to allow subclasses to access these fields but not outside the package
    protected String name;
    protected boolean isExtra;

    public PremiumTopping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    @Override
    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

    // getPrice method will be implemented in subclasses ( Meat, Cheese)
    // they can call isExtra to check whether to double the price
}
