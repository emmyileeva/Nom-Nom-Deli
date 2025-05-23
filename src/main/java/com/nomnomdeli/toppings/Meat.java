package com.nomnomdeli.toppings;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    // price of meat toppings based on size
    @Override
    public double getPrice(String size) {
        double basePrice;
        switch (size) {
            case "4":
                basePrice = 1.0;
                break;
            case "8":
                basePrice = 2.0;
                break;
            case "12":
                basePrice = 3.0;
                break;
            default:
                basePrice = 0.0; // default case for invalid size
                break;
        }
        return isExtra ? basePrice * 2 : basePrice; // double the price if it's extra
    }
}
