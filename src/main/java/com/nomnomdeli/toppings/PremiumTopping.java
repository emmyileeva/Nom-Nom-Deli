package com.nomnomdeli.toppings;

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
