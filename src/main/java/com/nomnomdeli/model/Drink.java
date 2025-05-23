package com.nomnomdeli.model;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.00; // Invalid size
        }
    }

    // Override the toString method to provide a string representation of the Drink object
    @Override
    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }
}
