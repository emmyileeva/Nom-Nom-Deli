package com.nomnomdeli.toppings;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    // price of meat toppings based on size
    @Override
    public double getPrice(String size) {
        double basePrice;
        double extraPrice = 0.0;

        switch (size) {
            case "4":
                basePrice = 1.0;
                extraPrice = 0.5;
                break;
            case "8":
                basePrice = 2.0;
                extraPrice = 1.0;
                break;
            case "12":
                basePrice = 3.0;
                extraPrice = 1.5;
                break;
            default:
                basePrice = 0.0; // default case for invalid size
                break;
        }
        return isExtra ? basePrice + extraPrice : basePrice; // add extra price if it's extra
    }
}
