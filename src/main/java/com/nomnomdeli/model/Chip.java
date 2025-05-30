package com.nomnomdeli.model;

// This class represents a Chip item in the app.

public class Chip {
    private String type;
    private static final double PRICE = 1.50;

    public Chip(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return PRICE;
    }

    // Override the toString method to provide a string representation of the Chip object
    @Override
    public String toString() {
        return type + " - $" + String.format("%.2f", PRICE);
    }
}
