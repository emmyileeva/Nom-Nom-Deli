package com.nomnomdeli.model;

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

    @Override
    public String toString() {
        return type + " Chips - $" + String.format("%.2f", PRICE);
    }
}
