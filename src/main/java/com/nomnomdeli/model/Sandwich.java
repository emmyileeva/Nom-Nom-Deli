package com.nomnomdeli.model;

import com.nomnomdeli.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public double getBasePrice() {
        switch (size) {
            case "4":
                return 5.50;
            case "8":
                return 7.00;
            case "12":
                return 8.50;
            default:
                return 0.00;
        }
    }

    // Calculate the price of toppings based on the size of the sandwich
    public double getToppingPrice() {
        double total = 0.00;
        for (Topping topping : toppings) {
            total += topping.getPrice(size);
        }
        return total;
    }

    public double getTotalPrice() {
        return getBasePrice() + getToppingPrice();
    }

    // Override the toString method to provide a string representation of the Sandwich object
    // using StringBuilder for better performance, especially when concatenating strings in a loop
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(breadType).append(" Sandwich\n");
        if (toasted) {
            sb.append("(Toasted)\n");
        }
        sb.append("Toppings:\n");
        for (Topping topping : toppings) {
            sb.append(" - ").append(topping.getName()).append("\n");
        }
        sb.append(String.format("Subtotal: $%.2f", getTotalPrice()));
        return sb.toString();
    }
}
