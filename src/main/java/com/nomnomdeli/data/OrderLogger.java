package com.nomnomdeli.data;

import com.nomnomdeli.model.Chip;
import com.nomnomdeli.model.Drink;
import com.nomnomdeli.model.Order;
import com.nomnomdeli.model.Sandwich;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// This class is responsible for saving order summaries to a CSV file.

public class OrderLogger {

    // path to the csv file where order history will be stored
    private static final String historyFile = "receipts/order_history.csv";

    // This method appends a new order summary to the order history file.
    public static void appendToOrderHistory(Order order) {
        try (FileWriter writer = new FileWriter(historyFile, true)) {
            writer.write("\n--- New Order ---\n");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write("Time: " + LocalDateTime.now().format(formatter) + "\n");

            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("Sandwich: " + sandwich.getName() + "\n");
            }

            for (Drink drink : order.getDrinks()) {
                writer.write("Drink: " + drink.getSize() + " " + drink.getFlavor() + "\n");
            }

            for (Chip chip : order.getChips()) {
                writer.write("Chips: " + chip.getType() + "\n");
            }

            writer.write("Total: $" + String.format("%.2f", order.getTotalPrice()) + "\n");

        } catch (IOException e) {
            System.err.println("Error writing to order history: " + e.getMessage());
        }
    }
}
