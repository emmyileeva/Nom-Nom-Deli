package com.nomnomdeli.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;
    private String orderId;
    private LocalDateTime orderTime;

    public Order() {
        this.orderTime = LocalDateTime.now();
        // Generate a unique order ID based on the current time
        this.orderId = "ORDER-" + orderTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addChip(Chip chip) {
        this.chips.add(chip);
    }

    public boolean isEmpty() {
        return sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty();
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void listSandwiches() {
        if (sandwiches.isEmpty()) {
            System.out.println("No sandwiches in this order.");
        } else {
            for (int i = 0; i < sandwiches.size(); i++) {
                System.out.println((i + 1) + ") " + sandwiches.get(i).getName());
            }
        }
    }

    public void removeSandwich(int index) {
        if (index >= 0 && index < sandwiches.size()) {
            sandwiches.remove(index);
            System.out.println("Sandwich removed successfully.");
        }
    }

    public void replaceSandwich(int index, Sandwich newSandwich) {
        if (index >= 0 && index < sandwiches.size()) {
            sandwiches.set(index, newSandwich);
            System.out.println("Sandwich replaced successfully.");
        }
    }

    //Calculate the total price of the order
    // Later will refactor to use streams here
    public double getTotalPrice() {
        double total = 0.0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getTotalPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chip chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    // Receipt summary for the order
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order ID: ").append(orderId).append("\n");
        orderDetails.append("Order Time: ").append(orderTime).append("\n\n");

        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            orderDetails.append("No items in this order.\n");
        } else {
            if (!sandwiches.isEmpty()) {
                orderDetails.append("Sandwiches:\n");
                for (Sandwich sandwich : sandwiches) {
                    orderDetails.append(sandwich).append("\n\n");
                }
            }

            if (!drinks.isEmpty()) {
                orderDetails.append("Drinks:\n");
                for (Drink drink : drinks) {
                    orderDetails.append(" - ").append(drink).append("\n");
                }
            }

            if (!chips.isEmpty()) {
                orderDetails.append("Chips:\n");
                for (Chip chip : chips) {
                    orderDetails.append(" - ").append(chip).append("\n");
                }
            }

            orderDetails.append(String.format("\nTotal: $%.2f", getTotalPrice()));
        }

        return orderDetails.toString();
    }
}

