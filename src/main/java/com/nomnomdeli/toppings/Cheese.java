package com.nomnomdeli.toppings;

public class Cheese extends PremiumTopping {

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    // price of cheese toppings based on size
    @Override
    public double getPrice(String size) {
        double basePrice;
        double extraPrice = 0.0;

        switch (size) {
            case "4":
                basePrice = 0.75;
                extraPrice = 0.30;
                break;
            case "8":
                basePrice = 1.5;
                extraPrice = 0.60;
                break;
            case "12":
                basePrice = 2.25;
                extraPrice = 0.90;
                break;
            default:
                basePrice = 0.0; // default case for invalid size
                break;
        }
        return isExtra ? basePrice + extraPrice : basePrice; // add extra price if it's extra
    }
}
