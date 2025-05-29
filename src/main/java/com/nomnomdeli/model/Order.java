package com.nomnomdeli.model;

import com.nomnomdeli.utils.ColorTextHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// This class represents an Order in the app.

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
    public double getTotalPrice() {
        return sandwiches.stream().mapToDouble(Sandwich::getTotalPrice).sum() +
                drinks.stream().mapToDouble(Drink::getPrice).sum() +
                chips.stream().mapToDouble(Chip::getPrice).sum();
    }

    // Receipt summary for the order
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();

        orderDetails.append(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n", ColorTextHelper.AQUA));
        orderDetails.append(ColorTextHelper.colorize("🧾   N O M   N O M   D E L I   R E C E I P T   🧾\n", ColorTextHelper.AQUA));
        orderDetails.append(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n", ColorTextHelper.AQUA));
        orderDetails.append("\n");

        orderDetails.append(ColorTextHelper.colorize("Order ID: ", ColorTextHelper.MINT))
                .append(ColorTextHelper.colorize(orderId, ColorTextHelper.LIME)).append("\n");
        orderDetails.append(ColorTextHelper.colorize("Order Time: ", ColorTextHelper.MINT))
                .append(ColorTextHelper.colorize(orderTime.toString(), ColorTextHelper.LIME)).append("\n\n");

        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            orderDetails.append(ColorTextHelper.colorize("No items in this order.\n", ColorTextHelper.PINK));
        } else {
            if (!sandwiches.isEmpty()) {
                orderDetails.append(ColorTextHelper.colorize("🥪 Sandwiches:\n", ColorTextHelper.LIME));
                for (Sandwich sandwich : sandwiches) {
                    orderDetails.append(ColorTextHelper.colorize(sandwich.toString(), ColorTextHelper.LIME)).append("\n");
                    orderDetails.append(ColorTextHelper.colorize("----------------------------------------------\n", ColorTextHelper.FRESH));
                }
                orderDetails.append("\n");
            }

            if (!drinks.isEmpty()) {
                orderDetails.append(ColorTextHelper.colorize("🥤 Drinks:\n", ColorTextHelper.LIME));
                for (Drink drink : drinks) {
                    orderDetails.append(" - ").append(ColorTextHelper.colorize(drink.toString(), ColorTextHelper.LIME)).append("\n");
                }
                orderDetails.append("\n");
            }

            if (!chips.isEmpty()) {
                orderDetails.append(ColorTextHelper.colorize("🥔 Chips:\n", ColorTextHelper.LIME));
                for (Chip chip : chips) {
                    orderDetails.append(" - ").append(ColorTextHelper.colorize(chip.toString(), ColorTextHelper.LIME)).append("\n");
                }
                orderDetails.append("\n");
            }

            orderDetails.append(ColorTextHelper.colorize(String.format("💵 Total: $%.2f\n", getTotalPrice()), ColorTextHelper.MINT));
        }

        orderDetails.append(ColorTextHelper.colorize("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", ColorTextHelper.AQUA));
        return orderDetails.toString();
    }
}

